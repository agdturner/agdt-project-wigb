/*
 * Copyright 2018 geoagdt.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.andyt.projects.wigb.process;

import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import uk.ac.leeds.ccg.andyt.projects.wigb.core.WIGB_Environment;
import uk.ac.leeds.ccg.andyt.projects.wigb.core.WIGB_Strings;
import uk.ac.leeds.ccg.andyt.projects.wigb.io.WIGB_Files;
import uk.ac.leeds.ccg.andyt.projects.wigb.core.WIGB_Object;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_Collection;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_Combined_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_Data;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_HHOLD_Handler;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_ID;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.WIGB_WaAS_PERSON_Handler;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.hhold.WIGB_WaAS_Wave1_HHOLD_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.hhold.WIGB_WaAS_Wave2_HHOLD_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.hhold.WIGB_WaAS_Wave3_HHOLD_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.hhold.WIGB_WaAS_Wave4_HHOLD_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.hhold.WIGB_WaAS_Wave5_HHOLD_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.person.WIGB_WaAS_Wave1_PERSON_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.person.WIGB_WaAS_Wave2_PERSON_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.person.WIGB_WaAS_Wave3_PERSON_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.person.WIGB_WaAS_Wave4_PERSON_Record;
import uk.ac.leeds.ccg.andyt.projects.wigb.data.waas.person.WIGB_WaAS_Wave5_PERSON_Record;

/**
 *
 * @author geoagdt
 */
public class WIGB_Main_Process extends WIGB_Object {

    // For convenience
    protected final WIGB_WaAS_Data data;
    protected final WIGB_Strings Strings;
    protected final WIGB_Files Files;

    public WIGB_Main_Process(WIGB_Environment env) {
        super(env);
        data = env.data;
        Strings = env.Strings;
        Files = env.Files;
    }

    public static void main(String[] args) {
        WIGB_Main_Process p;
        WIGB_Environment env;
        env = new WIGB_Environment();
        p = new WIGB_Main_Process(env);
        p.Files.setDataDirectory(new File(System.getProperty("user.dir"), "data"));
        // Main switches
        //p.doJavaCodeGeneration = true;
        p.doLoadDataIntoCaches = true; // rename/reuse just left here for convenience...
        p.run();
    }

    public void run() {

        if (doJavaCodeGeneration) {
            runJavaCodeGeneration();
        }

        File indir;
        File outdir;
        File generateddir;
        WIGB_WaAS_HHOLD_Handler hholdHandler;

        indir = Files.getWaASInputDir();
        generateddir = Files.getGeneratedWaASDirectory();
        outdir = new File(generateddir, "Subsets");
        outdir.mkdirs();
        hholdHandler = new WIGB_WaAS_HHOLD_Handler(Env.Files, Env.Strings, indir);

        int chunkSize;
        chunkSize = 256; //1024; 512; 256;
//        doDataProcessingStep1(indir, outdir, hholdHandler);
//        doDataProcessingStep2(indir, outdir, hholdHandler, chunkSize);
        doDataProcessingStep3(outdir);
    }

    /**
     * Go through households for all waves and figure which ones have not
     * significantly changed in terms of household composition. Having children
     * and children leaving home is fine. Anything else is perhaps an issue.
     *
     * @param outdir
     */
    public void doDataProcessingStep3(File outdir) {
        System.out.println(data.lookup.size());
        System.out.println(data.data.size());

        long n = data.data.keySet().stream()
                .mapToLong(cID -> {
                    WIGB_WaAS_Collection c;
                    c = data.getCollection(cID);
                    long nc = c.getData().keySet().stream()
                            .mapToLong(CASEW1 -> {
                                WIGB_WaAS_Combined_Record cr;
                                cr = c.getData().get(CASEW1);
                                c.getData().get(CASEW1);
                                try {
                                byte w1 = cr.w1Record.getHhold().getNUMADULT();
                                byte w2 = cr.w2Record.getHhold().getNUMADULT();
                                byte w3 = cr.w3Record.getHhold().getNUMADULT();
                                byte w4 = cr.w4Record.getHhold().getNUMADULT();
                                byte w5 = cr.w5Record.getHhold().getNUMADULT();
                                if (w1 == w2 && w2 == w3 && w3 == w4 && w4 == w5) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                                } catch (NullPointerException e) {
                                    return 0;
                                }
                            }).sum();
                    return nc;
                }).sum();
        System.out.println("There are " + n + " households that contain the "
                + "same number of adults throughout");
//        /**
//         * Stream through the data and calculate the total value of UK Land in
//         * Wave 1 households. This value is an aggregate of numerical class
//         * values.
//         */
//        long tDVLUKVAL = data.data.keySet().stream()
//                .mapToLong(cID -> {
//                    WIGB_WaAS_Collection c;
//                    c = data.getCollection(cID);
//                    long cDVLUKVAL = c.getData().keySet().stream()
//                            .mapToLong(CASEW1 -> {
//                                WIGB_WaAS_Combined_Record cr;
//                                cr = c.getData().get(CASEW1);
//                                int DVLUKVAL;
//                                DVLUKVAL = cr.w1Record.getHhold().getDVLUKVAL();
//                                if (DVLUKVAL == Integer.MIN_VALUE) {
//                                    DVLUKVAL = 0;
//                                }
//                                return DVLUKVAL;
//                            }).sum();
//                    data.clearCollection(cID);
//                    return cDVLUKVAL;  // Total value of UK Land in c.
//                }).sum();
//        System.out.println("Total value of UK Land in Wave 1 " + tDVLUKVAL);
        //
//        /**
//         * Stream through the data and calculate the total income in the last 12
//         * months of all individual people. This value is an aggregate of
//         * numerical class values.
//         */
//        long tFINCVB = data.data.keySet().stream()
//                .mapToLong(cID -> {
//                    WIGB_WaAS_Collection c;
//                    c = data.getCollection(cID);
//                    long cFINCVB = c.getData().keySet().stream()
//                            .mapToLong(CASEW1 -> {
//                                WIGB_WaAS_Combined_Record cr;
//                                cr = c.getData().get(CASEW1);
//                                long hFINCVB = cr.w1Record.getPeople().stream()
//                                        .mapToLong(p -> {
//                                            byte FINCVB;
//                                            FINCVB = p.getFINCVB();
//                                            //if (FINCVB == Byte.MIN_VALUE) {
//                                            if (FINCVB < 0) {
//                                                FINCVB = 0;
//                                            }
//                                            return FINCVB;
//                                        }).sum();
//                                return hFINCVB;
//                            }).sum();
//                    data.clearCollection(cID);
//                    return cFINCVB;  // Total income in the last 12 months.
//                }).sum();
//        System.out.println("Total income in the last 12 months " + tFINCVB);
        /**
         * The main WaAS data store. Keys are Collection IDs.
         */
        TreeMap<Integer, String> vIDToVName;
        TreeMap<String, Integer> vNameToVID;
        vIDToVName = new TreeMap<>();
        vNameToVID = new TreeMap<>();
        String sDVLUKDEBT = "DVLUKDEBT";
        addVariable(sDVLUKDEBT, vIDToVName, vNameToVID);
        String sDVLUKVAL = "DVLUKVAL";
        addVariable(sDVLUKVAL, vIDToVName, vNameToVID);

//                    WIGB_WaAS_Combined_Record cr;
//                    cr = c.getData().get(CASEW1);
//                    //cr.w1Record.getHhold().getDVLUKDEBT(); // Debt on UK Land
//                    tDVLUKVAL += cr.w1Record.getHhold().getDVLUKVAL();  // Value of UK Land
//                    //cr.w1Record.getHhold().getDVOPRDEBT(); // Debt on other property
//                    //cr.w1Record.getHhold().getDVOPRVAL();  // Value of other property
//                    //cr.w1Record.getHhold().getHPROPW(); // Total property wealth
//                    //cr.w1Record.getHhold().getGOR(); // Government Office Region Code
//                    cr.w2Record.getHhold().getDVLUKVAL();  // Value of UK Land
//                    cr.w3Record.getHhold().getDVLUKVAL_SUM();  // Value of UK Land
//                    cr.w4Record.getHhold().getDVLUKVAL_SUM();  // Value of UK Land
//                    cr.w5Record.getHhold().getDVLUKVAL_SUM();  // Value of UK Land
//                    cr.w1Record.getPeople().stream()
//                            .forEach(w1person -> {
//                                w1person.getDVLUKDEBT(); // Derived - Total land uk debt
//                                w1person.getDVLUKV(); // Derived - Total land uk value
//                            });
//                });
    }

    protected void addVariable(String s, TreeMap<Integer, String> vIDToVName,
            TreeMap<String, Integer> vNameToVID) {
        vIDToVName.put(0, s);
        vNameToVID.put(s, 0);
    }

    /**
     * Merge Person and Household Data
     *
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param chunkSize
     */
    public void doDataProcessingStep2(File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int chunkSize) {
        WIGB_WaAS_PERSON_Handler personHandler;
        personHandler = new WIGB_WaAS_PERSON_Handler(Files, Strings, indir);
        System.out.println("Merge Person and Household Data");
        int nOC = doDataProcessingStep2Wave1(
                data, personHandler, indir, outdir, hholdHandler, chunkSize);
        doDataProcessingStep2Wave2(
                data, personHandler, indir, outdir, hholdHandler, nOC);
        doDataProcessingStep2Wave3(
                data, personHandler, indir, outdir, hholdHandler, nOC);
        doDataProcessingStep2Wave4(
                data, personHandler, indir, outdir, hholdHandler, nOC);
        doDataProcessingStep2Wave5(
                data, personHandler, indir, outdir, hholdHandler, nOC);
        System.out.println(data.lookup.size());
        System.out.println(data.data.size());
        Env.cacheData();
    }

    /**
     * Merge Person and Household Data for Wave 1.
     *
     * @param data
     * @param personHandler
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param chunkSize
     * @return
     */
    public static int doDataProcessingStep2Wave1(
            WIGB_WaAS_Data data,
            WIGB_WaAS_PERSON_Handler personHandler,
            File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int chunkSize) {
        System.out.println("Wave 1");
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave1_HHOLD_Record> hs;
        hs = hholdHandler.loadCacheSubsetWave1();
        Set<WIGB_WaAS_ID> set;
        set = hs.keySet();
        int nOC;
        nOC = (int) Math.ceil((double) set.size() / (double) chunkSize);
        Object[] ps;
        ps = personHandler.loadSubsetWave1(set, nOC, WIGB_WaAS_Data.W1, outdir);
        HashMap<Short, Set<WIGB_WaAS_ID>> cIDs;
        cIDs = (HashMap<Short, Set<WIGB_WaAS_ID>>) ps[0];
        HashMap<Short, File> cFs;
        cFs = (HashMap<Short, File>) ps[1];
        cIDs.keySet().stream()
                .forEach(cID -> {
                    System.out.println("collectionID " + cID);
                    WIGB_WaAS_Collection c;
                    c = new WIGB_WaAS_Collection(cID);
                    data.data.put(cID, c);
                    // Add household records.
                    Set<WIGB_WaAS_ID> s;
                    s = cIDs.get(cID);
                    s.stream()
                            .forEach(ID -> {
                                short CASEW1 = ID.getCASEW1();
                                data.lookup.put(CASEW1, cID);
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    cr = new WIGB_WaAS_Combined_Record(CASEW1);
                                    m.put(CASEW1, cr);
                                }
                                cr.w1Record.setHhold(hs.get(ID));
                            });
                    // Add person records.
                    File f;
                    BufferedReader br;
                    f = cFs.get(cID);
                    br = Generic_StaticIO.getBufferedReader(f);
                    br.lines()
                            .skip(1) // Skip header.
                            .forEach(line -> {
                                WIGB_WaAS_Wave1_PERSON_Record p;
                                p = new WIGB_WaAS_Wave1_PERSON_Record(line);
                                short CASEW1;
                                CASEW1 = p.getCASEW1();
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                cr.w1Record.getPeople().add(p);
                            });
                    // Close br
                    Generic_StaticIO.closeBufferedReader(br);
                    // Cache and clear collection
                    data.cacheSubsetCollection(cID, c);
                    data.clearCollection(cID);
                });

        return nOC;
    }

    /**
     * Merge Person and Household Data for Wave 2.
     *
     * @param data
     * @param personHandler
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param nOC
     */
    public static void doDataProcessingStep2Wave2(WIGB_WaAS_Data data,
            WIGB_WaAS_PERSON_Handler personHandler, File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int nOC) {
        System.out.println("Wave 2");
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave2_HHOLD_Record> hs;
        hs = hholdHandler.loadCacheSubsetWave2();
        Object[] ps;
        ps = personHandler.loadSubsetWave2(hs.keySet(), nOC, WIGB_WaAS_Data.W2,
                outdir);
        HashMap<Short, Set<WIGB_WaAS_ID>> cIDs;
        cIDs = (HashMap<Short, Set<WIGB_WaAS_ID>>) ps[0];
        HashMap<Short, File> cFs;
        cFs = (HashMap<Short, File>) ps[1];
        cIDs.keySet().stream()
                .forEach(cID -> {
                    System.out.println("collectionID " + cID);
                    WIGB_WaAS_Collection c;
                    c = data.getCollection(cID);
                    // Add household records.
                    Set<WIGB_WaAS_ID> s;
                    s = cIDs.get(cID);
                    s.stream()
                            .forEach(ID -> {
                                short CASEW1 = ID.getCASEW1();
                                data.lookup.put(CASEW1, cID);
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error?");
                                } else {
                                    cr.w2Record.setHhold(
                                            hs.get(ID));
                                }
                            });
                    // Add person records.
                    File f;
                    BufferedReader br;
                    f = cFs.get(cID);
                    br = Generic_StaticIO.getBufferedReader(f);
                    br.lines()
                            .skip(1) // Skip header.
                            .forEach(line -> {
                                WIGB_WaAS_Wave2_PERSON_Record p;
                                p = new WIGB_WaAS_Wave2_PERSON_Record(line);
                                short CASEW1;
                                CASEW1 = p.getCASEW1();
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error, "
                                            + "or this person may have "
                                            + "moved from one household "
                                            + "to another?");
                                } else {
                                    cr.w2Record.getPeople().add(p);
                                }
                            });
                    // Close br
                    Generic_StaticIO.closeBufferedReader(br);
                    // Cache and clear collection
                    data.cacheSubsetCollection(cID, c);
                    data.clearCollection(cID);
                });
    }

    /**
     * Merge Person and Household Data for Wave 3.
     *
     * @param data
     * @param personHandler
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param nOC
     */
    public static void doDataProcessingStep2Wave3(WIGB_WaAS_Data data,
            WIGB_WaAS_PERSON_Handler personHandler, File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int nOC) {
        System.out.println("Wave 3");
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave3_HHOLD_Record> hs;
        hs = hholdHandler.loadCacheSubsetWave3();
        Object[] ps;
        ps = personHandler.loadSubsetWave3(hs.keySet(), nOC, WIGB_WaAS_Data.W3,
                outdir);
        HashMap<Short, Set<WIGB_WaAS_ID>> cIDs;
        cIDs = (HashMap<Short, Set<WIGB_WaAS_ID>>) ps[0];
        HashMap<Short, File> cFs;
        cFs = (HashMap<Short, File>) ps[1];
        cIDs.keySet().stream()
                .forEach(cID -> {
                    System.out.println("collectionID " + cID);
                    WIGB_WaAS_Collection c;
                    c = data.getCollection(cID);
                    // Add household records.
                    Set<WIGB_WaAS_ID> s;
                    s = cIDs.get(cID);
                    s.stream()
                            .forEach(ID -> {
                                short CASEW1 = ID.getCASEW1();
                                data.lookup.put(CASEW1, cID);
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error?");
                                } else {
                                    cr.w3Record.setHhold(
                                            hs.get(ID));
                                }
                            });
                    // Add person records.
                    File f;
                    BufferedReader br;
                    f = cFs.get(cID);
                    br = Generic_StaticIO.getBufferedReader(f);
                    br.lines()
                            .skip(1) // Skip header.
                            .forEach(line -> {
                                WIGB_WaAS_Wave3_PERSON_Record p;
                                p = new WIGB_WaAS_Wave3_PERSON_Record(line);
                                short CASEW1;
                                CASEW1 = p.getCASEW1();
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error, "
                                            + "or this person may have "
                                            + "moved from one household "
                                            + "to another?");
                                } else {
                                    cr.w3Record.getPeople().add(p);
                                }
                            });
                    // Close br
                    Generic_StaticIO.closeBufferedReader(br);
                    // Cache and clear collection
                    data.cacheSubsetCollection(cID, c);
                    data.clearCollection(cID);
                });
    }

    /**
     * Merge Person and Household Data for Wave 4.
     *
     * @param data
     * @param personHandler
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param nOC
     */
    public static void doDataProcessingStep2Wave4(
            WIGB_WaAS_Data data,
            WIGB_WaAS_PERSON_Handler personHandler,
            File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int nOC) {
        // Wave 4
        System.out.println("Wave 4");
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave4_HHOLD_Record> hs;
        hs = hholdHandler.loadCacheSubsetWave4();
        Object[] ps;
        ps = personHandler.loadSubsetWave4(hs.keySet(), nOC, WIGB_WaAS_Data.W4,
                outdir);
        HashMap<Short, Set<WIGB_WaAS_ID>> cIDs;
        cIDs = (HashMap<Short, Set<WIGB_WaAS_ID>>) ps[0];
        HashMap<Short, File> cFs;
        cFs = (HashMap<Short, File>) ps[1];
        cIDs.keySet().stream()
                .forEach(cID -> {
                    System.out.println("collectionID " + cID);
                    WIGB_WaAS_Collection c;
                    c = data.getCollection(cID);
                    // Add household records.
                    Set<WIGB_WaAS_ID> s;
                    s = cIDs.get(cID);
                    s.stream()
                            .forEach(ID -> {
                                short CASEW1 = ID.getCASEW1();
                                data.lookup.put(CASEW1, cID);
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error?");
                                } else {
                                    cr.w4Record.setHhold(
                                            hs.get(ID));
                                }
                            });
                    // Add person records.
                    File f;
                    BufferedReader br;
                    f = cFs.get(cID);
                    br = Generic_StaticIO.getBufferedReader(f);
                    br.lines()
                            .skip(1) // Skip header.
                            .forEach(line -> {
                                WIGB_WaAS_Wave4_PERSON_Record p;
                                p = new WIGB_WaAS_Wave4_PERSON_Record(line);
                                short CASEW1;
                                CASEW1 = p.getCASEW1();
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error, "
                                            + "or this person may have "
                                            + "moved from one household "
                                            + "to another?");
                                } else {
                                    cr.w4Record.getPeople().add(p);
                                }
                            });
                    // Close br
                    Generic_StaticIO.closeBufferedReader(br);
                    // Cache and clear collection
                    data.cacheSubsetCollection(cID, c);
                    data.clearCollection(cID);
                });
    }

    /**
     * Merge Person and Household Data for Wave 5.
     *
     * @param data
     * @param personHandler
     * @param indir
     * @param outdir
     * @param hholdHandler
     * @param cOC
     */
    public static void doDataProcessingStep2Wave5(
            WIGB_WaAS_Data data,
            WIGB_WaAS_PERSON_Handler personHandler,
            File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler, int cOC) {
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave5_HHOLD_Record> hs;
        hs = hholdHandler.loadCacheSubsetWave5();
        Object[] ps;
        ps = personHandler.loadSubsetWave5(hs.keySet(), cOC, WIGB_WaAS_Data.W5,
                outdir);
        HashMap<Short, Set<WIGB_WaAS_ID>> cIDs;
        cIDs = (HashMap<Short, Set<WIGB_WaAS_ID>>) ps[0];
        HashMap<Short, File> cFs;
        cFs = (HashMap<Short, File>) ps[1];
        cIDs.keySet().stream()
                .forEach(cID -> {
                    WIGB_WaAS_Collection c;
                    c = data.getCollection(cID);
                    // Add household records.
                    Set<WIGB_WaAS_ID> s;
                    s = cIDs.get(cID);
                    s.stream()
                            .forEach(ID -> {
                                short CASEW1 = ID.getCASEW1();
                                data.lookup.put(CASEW1, cID);
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error?");
                                } else {
                                    cr.w5Record.setHhold(
                                            hs.get(ID));
                                }
                            });
                    // Add person records.
                    File f;
                    BufferedReader br;
                    f = cFs.get(cID);
                    br = Generic_StaticIO.getBufferedReader(f);
                    br.lines()
                            .skip(1) // Skip header.
                            .forEach(line -> {
                                WIGB_WaAS_Wave5_PERSON_Record p;
                                p = new WIGB_WaAS_Wave5_PERSON_Record(line);
                                short CASEW1;
                                CASEW1 = p.getCASEW1();
                                HashMap<Short, WIGB_WaAS_Combined_Record> m;
                                m = c.getData();
                                WIGB_WaAS_Combined_Record cr;
                                cr = m.get(CASEW1);
                                if (cr == null) {
                                    System.out.println("No combined record "
                                            + "for CASEW1 " + CASEW1 + "! "
                                            + "This may be a data error, "
                                            + "or this person may have "
                                            + "moved from one household "
                                            + "to another?");
                                } else {
                                    cr.w5Record.getPeople().add(p);
                                }
                            });
                    // Close br
                    Generic_StaticIO.closeBufferedReader(br);
                    // Cache and clear collection
                    data.cacheSubsetCollection(cID, c);
                    data.clearCollection(cID);
                });
    }

    /**
     * Method for running JavaCodeGeneration
     */
    public void runJavaCodeGeneration() {
        String[] args;
        args = null;
        WIGB_JavaCodeGenerator.main(args);
    }

    /**
     * Read input data and create subsets. Organise for person records that each
     * subset is split into separate files one for each collection. The
     * collections will be merged one by one in doDataProcessingStep2.
     *
     * @param indir
     * @param outdir
     * @param hholdHandler
     */
    public void doDataProcessingStep1(File indir, File outdir,
            WIGB_WaAS_HHOLD_Handler hholdHandler) {
        // For convenience/code brevity.
        byte nwaves;
        nwaves = WIGB_WaAS_Data.NWAVES;
        /**
         * Step 1: Load household data into cache and memory.
         */
        Object[] hholdData;
        hholdData = hholdHandler.load();

        /**
         * Step 2: Unpack hholdData. hholdData is an Object[] of length 2. r[0]
         * is a TreeMap with Integer keys which are the CASE id for the wave and
         * the values are WIGB_WaAS_Wave1Or2Or3Or4Or5_HHOLD_Record>. r[1] is an
         * array of TreeSets where: For Wave 5; r[1][0] is a list of CASEW5
         * values, r[1][1] is a list of CASEW4 values, r[1][2] is a list of
         * CASEW3 values, r[1][3] is a list of CASEW2 values, r[1][4] is a list
         * of CASEW1 values. For Wave 4; r[1][0] is a list of CASEW4 values,
         * r[1][1] is a list of CASEW3 values, r[1][2] is a list of CASEW2
         * values, r[1][3] is a list of CASEW1 values. For Wave 3; r[1][0] is a
         * list of CASEW3 values, r[1][1] is a list of CASEW2 values, r[1][2] is
         * a list of CASEW1 values. For Wave 2; r[1][0] is a list of CASEW2
         * values, r[1][1] is a list of CASEW1 values. For Wave 1: r[1][0] is a
         * list of CASEW1 values.
         */
        HashMap<Byte, TreeSet<WIGB_WaAS_ID>[]> iDLists;
        iDLists = new HashMap<>();
        // W1
        Object[] hholdDataW1;
        hholdDataW1 = (Object[]) hholdData[0];
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave1_HHOLD_Record> hholdW1;
        hholdW1 = (TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave1_HHOLD_Record>) hholdDataW1[0];
        TreeSet<WIGB_WaAS_ID>[] iDListsW1;
        iDListsW1 = (TreeSet<WIGB_WaAS_ID>[]) hholdDataW1[1];
        iDLists.put(WIGB_WaAS_Data.W1, iDListsW1);
        // W2
        Object[] hholdDataW2;
        hholdDataW2 = (Object[]) hholdData[1];
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave2_HHOLD_Record> hholdW2;
        hholdW2 = (TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave2_HHOLD_Record>) hholdDataW2[0];
        TreeSet<WIGB_WaAS_ID>[] iDListsW2;
        iDListsW2 = (TreeSet<WIGB_WaAS_ID>[]) hholdDataW2[1];
        iDLists.put(WIGB_WaAS_Data.W2, iDListsW2);
        // W3
        Object[] hholdDataW3;
        hholdDataW3 = (Object[]) hholdData[2];
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave3_HHOLD_Record> hholdW3;
        hholdW3 = (TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave3_HHOLD_Record>) hholdDataW3[0];
        TreeSet<WIGB_WaAS_ID>[] iDListsW3;
        iDListsW3 = (TreeSet<WIGB_WaAS_ID>[]) hholdDataW3[1];
        iDLists.put(WIGB_WaAS_Data.W3, iDListsW3);
        // W4
        Object[] hholdDataW4;
        hholdDataW4 = (Object[]) hholdData[3];
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave4_HHOLD_Record> hholdW4;
        hholdW4 = (TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave4_HHOLD_Record>) hholdDataW4[0];
        TreeSet<WIGB_WaAS_ID>[] iDListsW4;
        iDListsW4 = (TreeSet<WIGB_WaAS_ID>[]) hholdDataW4[1];
        iDLists.put(WIGB_WaAS_Data.W4, iDListsW4);
        // W5
        Object[] hholdDataW5;
        hholdDataW5 = (Object[]) hholdData[4];
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave5_HHOLD_Record> hholdW5;
        hholdW5 = (TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave5_HHOLD_Record>) hholdDataW5[0];
        TreeSet<WIGB_WaAS_ID>[] iDListsW5;
        iDListsW5 = (TreeSet<WIGB_WaAS_ID>[]) hholdDataW5[1];
        iDLists.put(WIGB_WaAS_Data.W5, iDListsW5);

        /**
         * Step 3: Print out the Number of Households in each wave.
         */
        for (byte wave = nwaves; wave > 0; wave--) {
            for (int i = 0; i < wave; i++) {
                if (i == 0) {
                    System.out.print("" + iDLists.get(wave)[i].size()
                            + "\tNumber of HHOLD IDs in Wave " + wave
                            + " reported as being in ");
                    for (int j = wave; j > 1; j--) {
                        System.out.print("Wave " + j + ", ");
                    }
                    System.out.println("Wave 1");
                } else {
                    System.out.println("" + iDLists.get(wave)[i].size()
                            + "\tNumber of HHOLD IDs from Wave " + (wave - i)
                            + " reported as being in Wave " + wave);
                }
            }
        }

        /**
         * Step 4: Get IDs of all hholds in all waves. This assumes that CASEW1
         * has been correctly encoded in each wave.
         */
        // Wave 1
        TreeSet<WIGB_WaAS_ID> all;
        all = new TreeSet<>();
        all.addAll(iDListsW1[0]);
        all.retainAll(iDListsW2[iDListsW2.length - 1]);
        all.retainAll(iDListsW3[iDListsW3.length - 1]);
        all.retainAll(iDListsW4[iDListsW4.length - 1]);
        all.retainAll(iDListsW5[iDListsW5.length - 1]);
        System.out.println("" + all.size()
                + "\tNumber of HHOLDs in Waves 5, 4, 3, 2 and 1");
        /**
         * Step 5: Working forward from Wave 1, get the subset of households
         * that are in all 5 waves; create mappings from the wave ID to the Wave
         * 1 ID and vice versa as appropriate (a mapping from Wave 1 to itself
         * is unnecessary).
         */
        Iterator<WIGB_WaAS_ID> ite;
        WIGB_WaAS_ID ID;
        short CASEW1;
        /**
         * Wave 1.
         */
        // Load test or generate hholdSubsetW1 subset.
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave1_HHOLD_Record> hholdSubsetW1;
        hholdSubsetW1 = hholdHandler.loadCacheSubsetWave1();
        if (hholdSubsetW1 == null) {
            hholdSubsetW1 = new TreeMap<>();
            ite = all.iterator();
            while (ite.hasNext()) {
                ID = ite.next();
                WIGB_WaAS_Wave1_HHOLD_Record rec;
                rec = hholdW1.get(ID);
//                if (rec == null) {
//                    System.out.println("Debug"); // Never occurs.
//                }
                hholdSubsetW1.put(ID, rec);
            }
            hholdHandler.cacheSubset(WIGB_WaAS_Data.W1, hholdSubsetW1);
        }
        /**
         * Wave 2.
         */
        // Load test or generate hholdSubsetW2 subset.
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave2_HHOLD_Record> hholdSubsetW2;
        hholdSubsetW2 = hholdHandler.loadCacheSubsetWave2();
        if (hholdSubsetW2 == null) {
            hholdSubsetW2 = new TreeMap<>();
            ite = hholdW2.keySet().iterator();
            while (ite.hasNext()) {
                ID = ite.next();
                WIGB_WaAS_Wave2_HHOLD_Record rec;
                rec = hholdW2.get(ID);
                CASEW1 = rec.getCASEW1();
                WIGB_WaAS_ID ID2;
                ID2 = new WIGB_WaAS_ID(CASEW1, CASEW1);
                if (all.contains(ID2)) {
                    hholdSubsetW2.put(ID, rec);
                }
            }
            hholdHandler.cacheSubset(WIGB_WaAS_Data.W2, hholdSubsetW2);
        }
        /**
         * Wave 3.
         */
        // Load test or generate hholdSubsetW3 subset.
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave3_HHOLD_Record> hholdSubsetW3;
        hholdSubsetW3 = hholdHandler.loadCacheSubsetWave3();
        if (hholdSubsetW3 == null) {
            hholdSubsetW3 = new TreeMap<>();
            ite = hholdW3.keySet().iterator();
            while (ite.hasNext()) {
                ID = ite.next();
                WIGB_WaAS_Wave3_HHOLD_Record rec;
                rec = hholdW3.get(ID);
                CASEW1 = rec.getCASEW1();
                WIGB_WaAS_ID ID2;
                ID2 = new WIGB_WaAS_ID(CASEW1, CASEW1);
                if (all.contains(ID2)) {
                    hholdSubsetW3.put(ID, rec);
                }
            }
            hholdHandler.cacheSubset(WIGB_WaAS_Data.W3, hholdSubsetW3);
        }
        /**
         * Wave 4.
         */
        // Load test or generate hholdSubsetW4 subset.
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave4_HHOLD_Record> hholdSubsetW4;
        hholdSubsetW4 = hholdHandler.loadCacheSubsetWave4();
        if (hholdSubsetW4 == null) {
            hholdSubsetW4 = new TreeMap<>();
            ite = hholdW4.keySet().iterator();
            while (ite.hasNext()) {
                ID = ite.next();
                WIGB_WaAS_Wave4_HHOLD_Record rec;
                rec = hholdW4.get(ID);
                CASEW1 = rec.getCASEW1();
                WIGB_WaAS_ID ID2;
                ID2 = new WIGB_WaAS_ID(CASEW1, CASEW1);
                if (all.contains(ID2)) {
                    hholdSubsetW4.put(ID, rec);
                }
            }
            hholdHandler.cacheSubset(WIGB_WaAS_Data.W4, hholdSubsetW4);
        }
        /**
         * Wave 5.
         */
        // Load test or generate hholdSubsetW5 subset.
        TreeMap<WIGB_WaAS_ID, WIGB_WaAS_Wave5_HHOLD_Record> hholdSubsetW5;
        hholdSubsetW5 = hholdHandler.loadCacheSubsetWave5();
        if (hholdSubsetW5 == null) {
            hholdSubsetW5 = new TreeMap<>();
            ite = hholdW5.keySet().iterator();
            while (ite.hasNext()) {
                ID = ite.next();
                WIGB_WaAS_Wave5_HHOLD_Record rec;
                rec = hholdW5.get(ID);
                CASEW1 = rec.getCASEW1();
                WIGB_WaAS_ID ID2;
                ID2 = new WIGB_WaAS_ID(CASEW1, CASEW1);
                if (all.contains(ID2)) {
                    hholdSubsetW5.put(ID, rec);
                }
            }
            hholdHandler.cacheSubset(WIGB_WaAS_Data.W5, hholdSubsetW5);
        }
    }

    boolean doJavaCodeGeneration = false;
    boolean doLoadDataIntoCaches = false;

}
