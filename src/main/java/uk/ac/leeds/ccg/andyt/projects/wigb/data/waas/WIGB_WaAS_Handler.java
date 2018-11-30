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
package uk.ac.leeds.ccg.andyt.projects.wigb.data.waas;

import java.io.File;
import uk.ac.leeds.ccg.andyt.generic.io.Generic_StaticIO;
import uk.ac.leeds.ccg.andyt.projects.wigb.core.WIGB_Environment;
import uk.ac.leeds.ccg.andyt.projects.wigb.core.WIGB_Object;

/**
 *
 * @author geoagdt
 */
public abstract class WIGB_WaAS_Handler extends WIGB_Object {

    protected String TYPE;
    protected File INDIR;

    public WIGB_WaAS_Handler(WIGB_Environment env) {
        super(env);
    }

    public File getInputFile(byte wave) {
        File f;
        String filename;
        filename = "was_wave_" + wave + "_" + TYPE + "_eul_final";
        if (wave < 4) {
            filename += "_v2";
        }
        filename += ".tab";
        f = new File(INDIR, filename);
        return f;
    }

    protected Object loadCache(byte wave, File cf) {
        Object r;
        System.out.println("<Loading wave " + wave + " " + TYPE + " WaAS "
                + "data from cache file " + cf + ">");
        r = Generic_StaticIO.readObject(cf);
        System.out.println("</Loading wave " + wave + " " + TYPE + " WaAS "
                + "data from cache file " + cf + ">");
        return r;
    }

    protected void storeCache(byte wave, File cf, Object o) {
        System.out.println("<Storing " + wave + " " + TYPE + " WaAS "
                + "in cache file " + cf + ">");
        Generic_StaticIO.writeObject(o, cf);
        System.out.println("</Storing " + wave + " " + TYPE + " WaAS "
                + "in cache file " + cf + ">");
    }
    
    public void storeCacheSubset(byte wave, Object o) {
        File dir;
        dir = Env.Files.getGeneratedWaASDirectory();
        dir = new File(dir, "Subsets");
        File cf;
        cf = new File(dir, TYPE + wave + "." + Env.Strings.S_dat);
        storeCache(wave, cf, o);
    }
    
    public void storeCacheSubsetCollection(short collectionID, byte wave, Object o) {
        File dir;
        dir = Env.Files.getGeneratedWaASDirectory();
        dir = new File(dir, "Subsets");
        File cf;
        cf = new File(dir, TYPE + wave + "_" + collectionID + "." + Env.Strings.S_dat);
        storeCache(wave, cf, o);
    }
    
    public Object loadCacheSubsetCollection(short collectionID, byte wave) {
        Object r;
        File dir;
        dir = Env.Files.getGeneratedWaASDirectory();
        dir = new File(dir, "Subsets");
        File cf;
        cf = new File(dir, TYPE + wave + "_" + collectionID + "." + Env.Strings.S_dat);
        r = loadCache(wave, cf);
        return r;
    }
}