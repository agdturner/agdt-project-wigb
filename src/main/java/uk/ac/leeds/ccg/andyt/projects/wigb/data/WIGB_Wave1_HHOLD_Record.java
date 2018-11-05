package uk.ac.leeds.ccg.andyt.projects.wigb.data;
public class WIGB_Wave1_HHOLD_Record extends WIGB_Wave1Or2_HHOLD_Record {
protected static Double DVPEPV_SUM;

protected static Double GCONTMN;

protected static Double GCONTRC;

protected static Double GCONTVL;

protected static Double HHLDR;

protected static Double HRPDVAGEW1BAND;

protected static Double HRTBYR;

protected static Double LANDOVSEAT_SUM;

protected static Double MDBEH;

protected static Double MDBEH2;

protected static Double MDBEH3;

protected static Double MDCAP;

protected static Double MDCAP2;

protected static Double MDCAP3;

protected static Double MDRST;

protected static Double MDRST2;

protected static Double MDRST3;

protected static Double MDWPF;

protected static Double MDWPF2;

protected static Double MDWPF3;

protected static Double MENDNUM3_I;

protected static Double MENDNUM3_IFLAG;

protected static Double MENDV11_I;

protected static Double MENDV11_IFLAG;

protected static Double MENDV5_I;

protected static Double MENDV5_IFLAG;

protected static Double MENDV7_I;

protected static Double MENDV7_IFLAG;

protected static Double MENDW2;

protected static Double MEVER;

protected static Double MNEG3_I;

protected static Double MNEG3_IFLAG;

protected static Double NUMDEPCH;

protected static Double VCARO;

protected static Double VCARW;

protected static Double VMODU;

protected static Double VNUMV;

protected static Double VNUMV2;

protected static Double VNUMV3;

protected static Double VNUMV4;

protected static Double VNUMV5;

protected static Double VPERS2;

protected static Double VPERS3;

protected static Double VPERS4;

protected static Double VPERS5;

protected static Double VPERS6;

protected static Double VPERS6_I;

protected static Double VPERS6_IFLAG;

protected static Double VSHPCT;

protected static Double VSHPCT2;

protected static Double VSHPCT3;

protected static Double VSHPCT4;

protected static Double VSHPCT5;

protected static Double XS_WGT;

public Double getDVPEPV_SUM() {
return DVPEPV_SUM;
}

public Double getGCONTMN() {
return GCONTMN;
}

public Double getGCONTRC() {
return GCONTRC;
}

public Double getGCONTVL() {
return GCONTVL;
}

public Double getHHLDR() {
return HHLDR;
}

public Double getHRPDVAGEW1BAND() {
return HRPDVAGEW1BAND;
}

public Double getHRTBYR() {
return HRTBYR;
}

public Double getLANDOVSEAT_SUM() {
return LANDOVSEAT_SUM;
}

public Double getMDBEH() {
return MDBEH;
}

public Double getMDBEH2() {
return MDBEH2;
}

public Double getMDBEH3() {
return MDBEH3;
}

public Double getMDCAP() {
return MDCAP;
}

public Double getMDCAP2() {
return MDCAP2;
}

public Double getMDCAP3() {
return MDCAP3;
}

public Double getMDRST() {
return MDRST;
}

public Double getMDRST2() {
return MDRST2;
}

public Double getMDRST3() {
return MDRST3;
}

public Double getMDWPF() {
return MDWPF;
}

public Double getMDWPF2() {
return MDWPF2;
}

public Double getMDWPF3() {
return MDWPF3;
}

public Double getMENDNUM3_I() {
return MENDNUM3_I;
}

public Double getMENDNUM3_IFLAG() {
return MENDNUM3_IFLAG;
}

public Double getMENDV11_I() {
return MENDV11_I;
}

public Double getMENDV11_IFLAG() {
return MENDV11_IFLAG;
}

public Double getMENDV5_I() {
return MENDV5_I;
}

public Double getMENDV5_IFLAG() {
return MENDV5_IFLAG;
}

public Double getMENDV7_I() {
return MENDV7_I;
}

public Double getMENDV7_IFLAG() {
return MENDV7_IFLAG;
}

public Double getMENDW2() {
return MENDW2;
}

public Double getMEVER() {
return MEVER;
}

public Double getMNEG3_I() {
return MNEG3_I;
}

public Double getMNEG3_IFLAG() {
return MNEG3_IFLAG;
}

public Double getNUMDEPCH() {
return NUMDEPCH;
}

public Double getVCARO() {
return VCARO;
}

public Double getVCARW() {
return VCARW;
}

public Double getVMODU() {
return VMODU;
}

public Double getVNUMV() {
return VNUMV;
}

public Double getVNUMV2() {
return VNUMV2;
}

public Double getVNUMV3() {
return VNUMV3;
}

public Double getVNUMV4() {
return VNUMV4;
}

public Double getVNUMV5() {
return VNUMV5;
}

public Double getVPERS2() {
return VPERS2;
}

public Double getVPERS3() {
return VPERS3;
}

public Double getVPERS4() {
return VPERS4;
}

public Double getVPERS5() {
return VPERS5;
}

public Double getVPERS6() {
return VPERS6;
}

public Double getVPERS6_I() {
return VPERS6_I;
}

public Double getVPERS6_IFLAG() {
return VPERS6_IFLAG;
}

public Double getVSHPCT() {
return VSHPCT;
}

public Double getVSHPCT2() {
return VSHPCT2;
}

public Double getVSHPCT3() {
return VSHPCT3;
}

public Double getVSHPCT4() {
return VSHPCT4;
}

public Double getVSHPCT5() {
return VSHPCT5;
}

public Double getXS_WGT() {
return XS_WGT;
}

public WIGB_Wave1_HHOLD_Record(String line) {
split = line.split("\t");
if (!split[0].trim().isEmpty()) {
XS_WGT = new Double(split[0]);
}
if (!split[1].trim().isEmpty()) {
HOUT = new Double(split[1]);
}
if (!split[2].trim().isEmpty()) {
ACCOM = new Double(split[2]);
}
if (!split[3].trim().isEmpty()) {
ACCOTH = new Double(split[3]);
}
if (!split[4].trim().isEmpty()) {
DVVESTV2_I = new Double(split[4]);
}
if (!split[5].trim().isEmpty()) {
DVVESTV2_IFLAG = new Double(split[5]);
}
if (!split[6].trim().isEmpty()) {
DVVESTV3_I = new Double(split[6]);
}
if (!split[7].trim().isEmpty()) {
DVVESTV3_IFLAG = new Double(split[7]);
}
if (!split[8].trim().isEmpty()) {
DVVESTV_I = new Double(split[8]);
}
if (!split[9].trim().isEmpty()) {
DVVESTV_IFLAG = new Double(split[9]);
}
if (!split[10].trim().isEmpty()) {
DVVOVAL_I = new Double(split[10]);
}
if (!split[11].trim().isEmpty()) {
DVVOVAL_IFLAG = new Double(split[11]);
}
if (!split[12].trim().isEmpty()) {
DVVPERV_I = new Double(split[12]);
}
if (!split[13].trim().isEmpty()) {
DVVPERV_IFLAG = new Double(split[13]);
}
if (!split[14].trim().isEmpty()) {
EINTPAY = new Double(split[14]);
}
if (!split[15].trim().isEmpty()) {
EINTRAT = new Double(split[15]);
}
if (!split[16].trim().isEmpty()) {
EINTRAT_I = new Double(split[16]);
}
if (!split[17].trim().isEmpty()) {
EINTRAT_IFLAG = new Double(split[17]);
}
if (!split[18].trim().isEmpty()) {
EOTHIRR = new Double(split[18]);
}
if (!split[19].trim().isEmpty()) {
EOTHIVA = new Double(split[19]);
}
if (!split[20].trim().isEmpty()) {
EOTHIVB = new Double(split[20]);
}
if (!split[21].trim().isEmpty()) {
EOTHREG = new Double(split[21]);
}
if (!split[22].trim().isEmpty()) {
EOTHRVA = new Double(split[22]);
}
if (!split[23].trim().isEmpty()) {
EOTHRVB = new Double(split[23]);
}
if (!split[24].trim().isEmpty()) {
EPRPER = new Double(split[24]);
}
if (!split[25].trim().isEmpty()) {
EPRVAL = new Double(split[25]);
}
if (!split[26].trim().isEmpty()) {
EPRVPAY = new Double(split[26]);
}
if (!split[27].trim().isEmpty()) {
EQFILTER = new Double(split[27]);
}
if (!split[28].trim().isEmpty()) {
EQREAS1 = new Double(split[28]);
}
if (!split[29].trim().isEmpty()) {
EQREAS2 = new Double(split[29]);
}
if (!split[30].trim().isEmpty()) {
EQREAS3 = new Double(split[30]);
}
if (!split[31].trim().isEmpty()) {
EQREAS4 = new Double(split[31]);
}
if (!split[32].trim().isEmpty()) {
EQREL = new Double(split[32]);
}
if (!split[33].trim().isEmpty()) {
EQREL_I = new Double(split[33]);
}
if (!split[34].trim().isEmpty()) {
EQREL_IFLAG = new Double(split[34]);
}
if (!split[35].trim().isEmpty()) {
EQTYPE = new Double(split[35]);
}
if (!split[36].trim().isEmpty()) {
EQTYPE_I = new Double(split[36]);
}
if (!split[37].trim().isEmpty()) {
EQTYPE_IFLAG = new Double(split[37]);
}
if (!split[38].trim().isEmpty()) {
EQVALB = new Double(split[38]);
}
if (!split[39].trim().isEmpty()) {
EQVAL = new Double(split[39]);
}
if (!split[40].trim().isEmpty()) {
EQVAL_I = new Double(split[40]);
}
if (!split[41].trim().isEmpty()) {
EQVAL_IFLAG = new Double(split[41]);
}
if (!split[42].trim().isEmpty()) {
EQWHEN = new Double(split[42]);
}
if (!split[43].trim().isEmpty()) {
EQYES = new Double(split[43]);
}
if (!split[44].trim().isEmpty()) {
EQYES_I = new Double(split[44]);
}
if (!split[45].trim().isEmpty()) {
EQYES_IFLAG = new Double(split[45]);
}
if (!split[46].trim().isEmpty()) {
ERECMB = new Double(split[46]);
}
if (!split[47].trim().isEmpty()) {
ERECM = new Double(split[47]);
}
if (!split[48].trim().isEmpty()) {
ERECTAX = new Double(split[48]);
}
if (!split[49].trim().isEmpty()) {
ERENTAM = new Double(split[49]);
}
if (!split[50].trim().isEmpty()) {
ERENTB = new Double(split[50]);
}
if (!split[51].trim().isEmpty()) {
ERVPRP = new Double(split[51]);
}
if (!split[52].trim().isEmpty()) {
ERVPRP_I = new Double(split[52]);
}
if (!split[53].trim().isEmpty()) {
ERVPRP_IFLAG = new Double(split[53]);
}
if (!split[54].trim().isEmpty()) {
ERVRECB = new Double(split[54]);
}
if (!split[55].trim().isEmpty()) {
ERVREC = new Double(split[55]);
}
if (!split[56].trim().isEmpty()) {
ERVREG = new Double(split[56]);
}
if (!split[57].trim().isEmpty()) {
ERVRENT = new Double(split[57]);
}
if (!split[58].trim().isEmpty()) {
ERVSUMB = new Double(split[58]);
}
if (!split[59].trim().isEmpty()) {
ERVSUM = new Double(split[59]);
}
if (!split[60].trim().isEmpty()) {
ERVTAX = new Double(split[60]);
}
if (!split[61].trim().isEmpty()) {
FLTTYP = new Double(split[61]);
}
if (!split[62].trim().isEmpty()) {
FURN = new Double(split[62]);
}
if (!split[63].trim().isEmpty()) {
GCOLLEC = new Double(split[63]);
}
if (!split[64].trim().isEmpty()) {
GCOLLEC_I = new Double(split[64]);
}
if (!split[65].trim().isEmpty()) {
GCOLLEC_IFLAG = new Double(split[65]);
}
if (!split[66].trim().isEmpty()) {
GCOLLVB = new Double(split[66]);
}
if (!split[67].trim().isEmpty()) {
GCOLLV = new Double(split[67]);
}
if (!split[68].trim().isEmpty()) {
GCOLLV_I = new Double(split[68]);
}
if (!split[69].trim().isEmpty()) {
GCOLLV_IFLAG = new Double(split[69]);
}
if (!split[70].trim().isEmpty()) {
GCONTMN = new Double(split[70]);
}
if (!split[71].trim().isEmpty()) {
GCONTRC = new Double(split[71]);
}
if (!split[72].trim().isEmpty()) {
GCONTVB = new Double(split[72]);
}
if (!split[73].trim().isEmpty()) {
GCONTVB_I = new Double(split[73]);
}
if (!split[74].trim().isEmpty()) {
GCONTVB_IFLAG = new Double(split[74]);
}
if (!split[75].trim().isEmpty()) {
GCONTVLS2 = new Double(split[75]);
}
if (!split[76].trim().isEmpty()) {
GCONTVL = new Double(split[76]);
}
if (!split[77].trim().isEmpty()) {
GCPREAM = new Double(split[77]);
}
if (!split[78].trim().isEmpty()) {
HAGEB = new Double(split[78]);
}
if (!split[79].trim().isEmpty()) {
HAGEYR = new Double(split[79]);
}
if (!split[80].trim().isEmpty()) {
HBFROM = new Double(split[80]);
}
if (!split[81].trim().isEmpty()) {
HBUYSE = new Double(split[81]);
}
if (!split[82].trim().isEmpty()) {
HBUYYR = new Double(split[82]);
}
if (!split[83].trim().isEmpty()) {
HHOSCH = new Double(split[83]);
}
if (!split[84].trim().isEmpty()) {
HHOWN = new Double(split[84]);
}
if (!split[85].trim().isEmpty()) {
HPRICEB = new Double(split[85]);
}
if (!split[86].trim().isEmpty()) {
HPRICE = new Double(split[86]);
}
if (!split[87].trim().isEmpty()) {
HRTBEV = new Double(split[87]);
}
if (!split[88].trim().isEmpty()) {
HRTBYR = new Double(split[88]);
}
if (!split[89].trim().isEmpty()) {
HSETYPE = new Double(split[89]);
}
if (!split[90].trim().isEmpty()) {
HSHAREP = new Double(split[90]);
}
if (!split[91].trim().isEmpty()) {
HSHAREP_I = new Double(split[91]);
}
if (!split[92].trim().isEmpty()) {
HSHAREP_IFLAG = new Double(split[92]);
}
if (!split[93].trim().isEmpty()) {
HSHARE = new Double(split[93]);
}
if (!split[94].trim().isEmpty()) {
HSHARE_I = new Double(split[94]);
}
if (!split[95].trim().isEmpty()) {
HSHARE_IFLAG = new Double(split[95]);
}
if (!split[96].trim().isEmpty()) {
HVALB = new Double(split[96]);
}
if (!split[97].trim().isEmpty()) {
HVALRS1 = new Double(split[97]);
}
if (!split[98].trim().isEmpty()) {
HVALRS2 = new Double(split[98]);
}
if (!split[99].trim().isEmpty()) {
HVALRS3 = new Double(split[99]);
}
if (!split[100].trim().isEmpty()) {
HVALRS4 = new Double(split[100]);
}
if (!split[101].trim().isEmpty()) {
HVALRS5 = new Double(split[101]);
}
if (!split[102].trim().isEmpty()) {
HVALUE = new Double(split[102]);
}
if (!split[103].trim().isEmpty()) {
HVALUE_I = new Double(split[103]);
}
if (!split[104].trim().isEmpty()) {
HVALUE_IFLAG = new Double(split[104]);
}
if (!split[105].trim().isEmpty()) {
LLORD = new Double(split[105]);
}
if (!split[106].trim().isEmpty()) {
MALL2 = new Double(split[106]);
}
if (!split[107].trim().isEmpty()) {
MALL2_I = new Double(split[107]);
}
if (!split[108].trim().isEmpty()) {
MALL2_IFLAG = new Double(split[108]);
}
if (!split[109].trim().isEmpty()) {
MALL3 = new Double(split[109]);
}
if (!split[110].trim().isEmpty()) {
MALL3_I = new Double(split[110]);
}
if (!split[111].trim().isEmpty()) {
MALL3_IFLAG = new Double(split[111]);
}
if (!split[112].trim().isEmpty()) {
MALLTY2 = new Double(split[112]);
}
if (!split[113].trim().isEmpty()) {
MALLTY2_I = new Double(split[113]);
}
if (!split[114].trim().isEmpty()) {
MALLTY2_IFLAG = new Double(split[114]);
}
if (!split[115].trim().isEmpty()) {
MALLTY3 = new Double(split[115]);
}
if (!split[116].trim().isEmpty()) {
MALLTY3_I = new Double(split[116]);
}
if (!split[117].trim().isEmpty()) {
MALLTY3_IFLAG = new Double(split[117]);
}
if (!split[118].trim().isEmpty()) {
MALLTY = new Double(split[118]);
}
if (!split[119].trim().isEmpty()) {
MALLTY_I = new Double(split[119]);
}
if (!split[120].trim().isEmpty()) {
MALLTY_IFLAG = new Double(split[120]);
}
if (!split[121].trim().isEmpty()) {
MALL = new Double(split[121]);
}
if (!split[122].trim().isEmpty()) {
MALL_I = new Double(split[122]);
}
if (!split[123].trim().isEmpty()) {
MALL_IFLAG = new Double(split[123]);
}
if (!split[124].trim().isEmpty()) {
MARRS2 = new Double(split[124]);
}
if (!split[125].trim().isEmpty()) {
MARRS3 = new Double(split[125]);
}
if (!split[126].trim().isEmpty()) {
MARRS = new Double(split[126]);
}
if (!split[127].trim().isEmpty()) {
MDBEH2 = new Double(split[127]);
}
if (!split[128].trim().isEmpty()) {
MDBEH3 = new Double(split[128]);
}
if (!split[129].trim().isEmpty()) {
MDBEH = new Double(split[129]);
}
if (!split[130].trim().isEmpty()) {
MDCAP2 = new Double(split[130]);
}
if (!split[131].trim().isEmpty()) {
MDCAP3 = new Double(split[131]);
}
if (!split[132].trim().isEmpty()) {
MDCAP = new Double(split[132]);
}
if (!split[133].trim().isEmpty()) {
MDIFFPY = new Double(split[133]);
}
if (!split[134].trim().isEmpty()) {
MDRST2 = new Double(split[134]);
}
if (!split[135].trim().isEmpty()) {
MDRST3 = new Double(split[135]);
}
if (!split[136].trim().isEmpty()) {
MDRST = new Double(split[136]);
}
if (!split[137].trim().isEmpty()) {
MDWPF2 = new Double(split[137]);
}
if (!split[138].trim().isEmpty()) {
MDWPF3 = new Double(split[138]);
}
if (!split[139].trim().isEmpty()) {
MDWPF = new Double(split[139]);
}
if (!split[140].trim().isEmpty()) {
MENDNUM2 = new Double(split[140]);
}
if (!split[141].trim().isEmpty()) {
MENDNUM2_I = new Double(split[141]);
}
if (!split[142].trim().isEmpty()) {
MENDNUM2_IFLAG = new Double(split[142]);
}
if (!split[143].trim().isEmpty()) {
MENDNUM3 = new Double(split[143]);
}
if (!split[144].trim().isEmpty()) {
MENDNUM3_I = new Double(split[144]);
}
if (!split[145].trim().isEmpty()) {
MENDNUM3_IFLAG = new Double(split[145]);
}
if (!split[146].trim().isEmpty()) {
MENDNUM = new Double(split[146]);
}
if (!split[147].trim().isEmpty()) {
MENDNUM_I = new Double(split[147]);
}
if (!split[148].trim().isEmpty()) {
MENDNUM_IFLAG = new Double(split[148]);
}
if (!split[149].trim().isEmpty()) {
MENDV11 = new Double(split[149]);
}
if (!split[150].trim().isEmpty()) {
MENDV11_I = new Double(split[150]);
}
if (!split[151].trim().isEmpty()) {
MENDV11_IFLAG = new Double(split[151]);
}
if (!split[152].trim().isEmpty()) {
MENDV2 = new Double(split[152]);
}
if (!split[153].trim().isEmpty()) {
MENDV2_I = new Double(split[153]);
}
if (!split[154].trim().isEmpty()) {
MENDV2_IFLAG = new Double(split[154]);
}
if (!split[155].trim().isEmpty()) {
MENDV3 = new Double(split[155]);
}
if (!split[156].trim().isEmpty()) {
MENDV3_I = new Double(split[156]);
}
if (!split[157].trim().isEmpty()) {
MENDV3_IFLAG = new Double(split[157]);
}
if (!split[158].trim().isEmpty()) {
MENDV4 = new Double(split[158]);
}
if (!split[159].trim().isEmpty()) {
MENDV4_I = new Double(split[159]);
}
if (!split[160].trim().isEmpty()) {
MENDV4_IFLAG = new Double(split[160]);
}
if (!split[161].trim().isEmpty()) {
MENDV5 = new Double(split[161]);
}
if (!split[162].trim().isEmpty()) {
MENDV5_I = new Double(split[162]);
}
if (!split[163].trim().isEmpty()) {
MENDV5_IFLAG = new Double(split[163]);
}
if (!split[164].trim().isEmpty()) {
MENDV6 = new Double(split[164]);
}
if (!split[165].trim().isEmpty()) {
MENDV6_I = new Double(split[165]);
}
if (!split[166].trim().isEmpty()) {
MENDV6_IFLAG = new Double(split[166]);
}
if (!split[167].trim().isEmpty()) {
MENDV7 = new Double(split[167]);
}
if (!split[168].trim().isEmpty()) {
MENDV7_I = new Double(split[168]);
}
if (!split[169].trim().isEmpty()) {
MENDV7_IFLAG = new Double(split[169]);
}
if (!split[170].trim().isEmpty()) {
MENDV8 = new Double(split[170]);
}
if (!split[171].trim().isEmpty()) {
MENDVB11 = new Double(split[171]);
}
if (!split[172].trim().isEmpty()) {
MENDVB2 = new Double(split[172]);
}
if (!split[173].trim().isEmpty()) {
MENDVB3 = new Double(split[173]);
}
if (!split[174].trim().isEmpty()) {
MENDVB4 = new Double(split[174]);
}
if (!split[175].trim().isEmpty()) {
MENDVB5 = new Double(split[175]);
}
if (!split[176].trim().isEmpty()) {
MENDVB6 = new Double(split[176]);
}
if (!split[177].trim().isEmpty()) {
MENDVB7 = new Double(split[177]);
}
if (!split[178].trim().isEmpty()) {
MENDVB8 = new Double(split[178]);
}
if (!split[179].trim().isEmpty()) {
MENDVB = new Double(split[179]);
}
if (!split[180].trim().isEmpty()) {
MENDV = new Double(split[180]);
}
if (!split[181].trim().isEmpty()) {
MENDV_I = new Double(split[181]);
}
if (!split[182].trim().isEmpty()) {
MENDV_IFLAG = new Double(split[182]);
}
if (!split[183].trim().isEmpty()) {
MENDW2 = new Double(split[183]);
}
if (!split[184].trim().isEmpty()) {
MENDW2_I = new Double(split[184]);
}
if (!split[185].trim().isEmpty()) {
MENDW2_IFLAG = new Double(split[185]);
}
if (!split[186].trim().isEmpty()) {
MENDW3 = new Double(split[186]);
}
if (!split[187].trim().isEmpty()) {
MENDW3_I = new Double(split[187]);
}
if (!split[188].trim().isEmpty()) {
MENDW3_IFLAG = new Double(split[188]);
}
if (!split[189].trim().isEmpty()) {
MENDW = new Double(split[189]);
}
if (!split[190].trim().isEmpty()) {
MENDW_I = new Double(split[190]);
}
if (!split[191].trim().isEmpty()) {
MENDW_IFLAG = new Double(split[191]);
}
if (!split[192].trim().isEmpty()) {
MENDX2 = new Double(split[192]);
}
if (!split[193].trim().isEmpty()) {
MENDX3 = new Double(split[193]);
}
if (!split[194].trim().isEmpty()) {
MENDX = new Double(split[194]);
}
if (!split[195].trim().isEmpty()) {
MENDY11 = new Double(split[195]);
}
if (!split[196].trim().isEmpty()) {
MENDY2 = new Double(split[196]);
}
if (!split[197].trim().isEmpty()) {
MENDY3 = new Double(split[197]);
}
if (!split[198].trim().isEmpty()) {
MENDY4 = new Double(split[198]);
}
if (!split[199].trim().isEmpty()) {
MENDY5 = new Double(split[199]);
}
if (!split[200].trim().isEmpty()) {
MENDY6 = new Double(split[200]);
}
if (!split[201].trim().isEmpty()) {
MENDY7 = new Double(split[201]);
}
if (!split[202].trim().isEmpty()) {
MENDY8 = new Double(split[202]);
}
if (!split[203].trim().isEmpty()) {
MENDY = new Double(split[203]);
}
if (!split[204].trim().isEmpty()) {
MEVER = new Double(split[204]);
}
if (!split[205].trim().isEmpty()) {
MHOWPY2 = new Double(split[205]);
}
if (!split[206].trim().isEmpty()) {
MHOWPY3 = new Double(split[206]);
}
if (!split[207].trim().isEmpty()) {
MHOWPY = new Double(split[207]);
}
if (!split[208].trim().isEmpty()) {
MINC11 = new Double(split[208]);
}
if (!split[209].trim().isEmpty()) {
MINC12 = new Double(split[209]);
}
if (!split[210].trim().isEmpty()) {
MINC1 = new Double(split[210]);
}
if (!split[211].trim().isEmpty()) {
MINC2 = new Double(split[211]);
}
if (!split[212].trim().isEmpty()) {
MINC3 = new Double(split[212]);
}
if (!split[213].trim().isEmpty()) {
MINC4 = new Double(split[213]);
}
if (!split[214].trim().isEmpty()) {
MINC5 = new Double(split[214]);
}
if (!split[215].trim().isEmpty()) {
MINC6 = new Double(split[215]);
}
if (!split[216].trim().isEmpty()) {
MINC7 = new Double(split[216]);
}
if (!split[217].trim().isEmpty()) {
MINC8 = new Double(split[217]);
}
if (!split[218].trim().isEmpty()) {
MINC9 = new Double(split[218]);
}
if (!split[219].trim().isEmpty()) {
MJNAME01 = new Double(split[219]);
}
if (!split[220].trim().isEmpty()) {
MJNAME02 = new Double(split[220]);
}
if (!split[221].trim().isEmpty()) {
MJNAME03 = new Double(split[221]);
}
if (!split[222].trim().isEmpty()) {
MJNAME04 = new Double(split[222]);
}
if (!split[223].trim().isEmpty()) {
MJNAME18 = new Double(split[223]);
}
if (!split[224].trim().isEmpty()) {
MJNAME19 = new Double(split[224]);
}
if (!split[225].trim().isEmpty()) {
MJNAME20 = new Double(split[225]);
}
if (!split[226].trim().isEmpty()) {
MJNAME35 = new Double(split[226]);
}
if (!split[227].trim().isEmpty()) {
MJNAME36 = new Double(split[227]);
}
if (!split[228].trim().isEmpty()) {
MNAME2 = new Double(split[228]);
}
if (!split[229].trim().isEmpty()) {
MNAME3 = new Double(split[229]);
}
if (!split[230].trim().isEmpty()) {
MNAME = new Double(split[230]);
}
if (!split[231].trim().isEmpty()) {
MNEG2 = new Double(split[231]);
}
if (!split[232].trim().isEmpty()) {
MNEG2_I = new Double(split[232]);
}
if (!split[233].trim().isEmpty()) {
MNEG2_IFLAG = new Double(split[233]);
}
if (!split[234].trim().isEmpty()) {
MNEG3 = new Double(split[234]);
}
if (!split[235].trim().isEmpty()) {
MNEG3_I = new Double(split[235]);
}
if (!split[236].trim().isEmpty()) {
MNEG3_IFLAG = new Double(split[236]);
}
if (!split[237].trim().isEmpty()) {
MNEGB2 = new Double(split[237]);
}
if (!split[238].trim().isEmpty()) {
MNEGB3 = new Double(split[238]);
}
if (!split[239].trim().isEmpty()) {
MNEGB = new Double(split[239]);
}
if (!split[240].trim().isEmpty()) {
MNEG = new Double(split[240]);
}
if (!split[241].trim().isEmpty()) {
MNEG_I = new Double(split[241]);
}
if (!split[242].trim().isEmpty()) {
MNEG_IFLAG = new Double(split[242]);
}
if (!split[243].trim().isEmpty()) {
MNUMB = new Double(split[243]);
}
if (!split[244].trim().isEmpty()) {
MONAME2 = new Double(split[244]);
}
if (!split[245].trim().isEmpty()) {
MONAME3 = new Double(split[245]);
}
if (!split[246].trim().isEmpty()) {
MONAME = new Double(split[246]);
}
if (!split[247].trim().isEmpty()) {
MPAYB2 = new Double(split[247]);
}
if (!split[248].trim().isEmpty()) {
MPAYB3 = new Double(split[248]);
}
if (!split[249].trim().isEmpty()) {
MPAYB = new Double(split[249]);
}
if (!split[250].trim().isEmpty()) {
MPAYM2 = new Double(split[250]);
}
if (!split[251].trim().isEmpty()) {
MPAYM3 = new Double(split[251]);
}
if (!split[252].trim().isEmpty()) {
MPAYM = new Double(split[252]);
}
if (!split[253].trim().isEmpty()) {
MPP2 = new Double(split[253]);
}
if (!split[254].trim().isEmpty()) {
MPP3 = new Double(split[254]);
}
if (!split[255].trim().isEmpty()) {
MPP = new Double(split[255]);
}
if (!split[256].trim().isEmpty()) {
MREAS01 = new Double(split[256]);
}
if (!split[257].trim().isEmpty()) {
MREAS02 = new Double(split[257]);
}
if (!split[258].trim().isEmpty()) {
MREAS03 = new Double(split[258]);
}
if (!split[259].trim().isEmpty()) {
MREAS04 = new Double(split[259]);
}
if (!split[260].trim().isEmpty()) {
MREAS05 = new Double(split[260]);
}
if (!split[261].trim().isEmpty()) {
MREAS06 = new Double(split[261]);
}
if (!split[262].trim().isEmpty()) {
MREAS07 = new Double(split[262]);
}
if (!split[263].trim().isEmpty()) {
MREAS08 = new Double(split[263]);
}
if (!split[264].trim().isEmpty()) {
MREAS09 = new Double(split[264]);
}
if (!split[265].trim().isEmpty()) {
MREAS11 = new Double(split[265]);
}
if (!split[266].trim().isEmpty()) {
MREAS12 = new Double(split[266]);
}
if (!split[267].trim().isEmpty()) {
MREAS13 = new Double(split[267]);
}
if (!split[268].trim().isEmpty()) {
MREAS21 = new Double(split[268]);
}
if (!split[269].trim().isEmpty()) {
MREAS22 = new Double(split[269]);
}
if (!split[270].trim().isEmpty()) {
MREAS23 = new Double(split[270]);
}
if (!split[271].trim().isEmpty()) {
MTYPE2 = new Double(split[271]);
}
if (!split[272].trim().isEmpty()) {
MTYPE2_I = new Double(split[272]);
}
if (!split[273].trim().isEmpty()) {
MTYPE2_IFLAG = new Double(split[273]);
}
if (!split[274].trim().isEmpty()) {
MTYPE3 = new Double(split[274]);
}
if (!split[275].trim().isEmpty()) {
MTYPE3_I = new Double(split[275]);
}
if (!split[276].trim().isEmpty()) {
MTYPE3_IFLAG = new Double(split[276]);
}
if (!split[277].trim().isEmpty()) {
MTYPE = new Double(split[277]);
}
if (!split[278].trim().isEmpty()) {
MTYPE_I = new Double(split[278]);
}
if (!split[279].trim().isEmpty()) {
MTYPE_IFLAG = new Double(split[279]);
}
if (!split[280].trim().isEmpty()) {
MVAL2 = new Double(split[280]);
}
if (!split[281].trim().isEmpty()) {
MVAL2_I = new Double(split[281]);
}
if (!split[282].trim().isEmpty()) {
MVAL2_IFLAG = new Double(split[282]);
}
if (!split[283].trim().isEmpty()) {
MVAL3 = new Double(split[283]);
}
if (!split[284].trim().isEmpty()) {
MVAL3_I = new Double(split[284]);
}
if (!split[285].trim().isEmpty()) {
MVAL3_IFLAG = new Double(split[285]);
}
if (!split[286].trim().isEmpty()) {
MVALB2 = new Double(split[286]);
}
if (!split[287].trim().isEmpty()) {
MVALB3 = new Double(split[287]);
}
if (!split[288].trim().isEmpty()) {
MVALB = new Double(split[288]);
}
if (!split[289].trim().isEmpty()) {
MVAL = new Double(split[289]);
}
if (!split[290].trim().isEmpty()) {
MVAL_I = new Double(split[290]);
}
if (!split[291].trim().isEmpty()) {
MVAL_IFLAG = new Double(split[291]);
}
if (!split[292].trim().isEmpty()) {
MYLFT2 = new Double(split[292]);
}
if (!split[293].trim().isEmpty()) {
MYLFT3 = new Double(split[293]);
}
if (!split[294].trim().isEmpty()) {
MYLFT = new Double(split[294]);
}
if (!split[295].trim().isEmpty()) {
NUMCIVPTR = new Double(split[295]);
}
if (!split[296].trim().isEmpty()) {
NVESTV = new Double(split[296]);
}
if (!split[297].trim().isEmpty()) {
OFINAL = new Double(split[297]);
}
if (!split[298].trim().isEmpty()) {
OTHMORT = new Double(split[298]);
}
if (!split[299].trim().isEmpty()) {
TEN1 = new Double(split[299]);
}
if (!split[300].trim().isEmpty()) {
TEN1_I = new Double(split[300]);
}
if (!split[301].trim().isEmpty()) {
TEN1_IFLAG = new Double(split[301]);
}
if (!split[302].trim().isEmpty()) {
TIED = new Double(split[302]);
}
if (!split[303].trim().isEmpty()) {
VCARN = new Double(split[303]);
}
if (!split[304].trim().isEmpty()) {
VCARN_I = new Double(split[304]);
}
if (!split[305].trim().isEmpty()) {
VCARN_IFLAG = new Double(split[305]);
}
if (!split[306].trim().isEmpty()) {
VCARO = new Double(split[306]);
}
if (!split[307].trim().isEmpty()) {
VCARW = new Double(split[307]);
}
if (!split[308].trim().isEmpty()) {
VESTV2 = new Double(split[308]);
}
if (!split[309].trim().isEmpty()) {
VESTV2_I = new Double(split[309]);
}
if (!split[310].trim().isEmpty()) {
VESTV2_IFLAG = new Double(split[310]);
}
if (!split[311].trim().isEmpty()) {
VESTV = new Double(split[311]);
}
if (!split[312].trim().isEmpty()) {
VESTV_I = new Double(split[312]);
}
if (!split[313].trim().isEmpty()) {
VESTV_IFLAG = new Double(split[313]);
}
if (!split[314].trim().isEmpty()) {
VESVB2 = new Double(split[314]);
}
if (!split[315].trim().isEmpty()) {
VESVB = new Double(split[315]);
}
if (!split[316].trim().isEmpty()) {
VMODU = new Double(split[316]);
}
if (!split[317].trim().isEmpty()) {
VNUMV2 = new Double(split[317]);
}
if (!split[318].trim().isEmpty()) {
VNUMV3 = new Double(split[318]);
}
if (!split[319].trim().isEmpty()) {
VNUMV4 = new Double(split[319]);
}
if (!split[320].trim().isEmpty()) {
VNUMV5 = new Double(split[320]);
}
if (!split[321].trim().isEmpty()) {
VNUMV = new Double(split[321]);
}
if (!split[322].trim().isEmpty()) {
VOTHT = new Double(split[322]);
}
if (!split[323].trim().isEmpty()) {
VOTHT_I = new Double(split[323]);
}
if (!split[324].trim().isEmpty()) {
VOTHT_IFLAG = new Double(split[324]);
}
if (!split[325].trim().isEmpty()) {
VOTYP1 = new Double(split[325]);
}
if (!split[326].trim().isEmpty()) {
VOTYP1_I = new Double(split[326]);
}
if (!split[327].trim().isEmpty()) {
VOTYP1_IFLAG = new Double(split[327]);
}
if (!split[328].trim().isEmpty()) {
VOTYP2 = new Double(split[328]);
}
if (!split[329].trim().isEmpty()) {
VOTYP2_I = new Double(split[329]);
}
if (!split[330].trim().isEmpty()) {
VOTYP2_IFLAG = new Double(split[330]);
}
if (!split[331].trim().isEmpty()) {
VOTYP3 = new Double(split[331]);
}
if (!split[332].trim().isEmpty()) {
VOTYP3_I = new Double(split[332]);
}
if (!split[333].trim().isEmpty()) {
VOTYP3_IFLAG = new Double(split[333]);
}
if (!split[334].trim().isEmpty()) {
VOTYP4 = new Double(split[334]);
}
if (!split[335].trim().isEmpty()) {
VOTYP4_I = new Double(split[335]);
}
if (!split[336].trim().isEmpty()) {
VOTYP4_IFLAG = new Double(split[336]);
}
if (!split[337].trim().isEmpty()) {
VOTYP5 = new Double(split[337]);
}
if (!split[338].trim().isEmpty()) {
VOTYP5_I = new Double(split[338]);
}
if (!split[339].trim().isEmpty()) {
VOTYP5_IFLAG = new Double(split[339]);
}
if (!split[340].trim().isEmpty()) {
VOVAL = new Double(split[340]);
}
if (!split[341].trim().isEmpty()) {
VOVAL_I = new Double(split[341]);
}
if (!split[342].trim().isEmpty()) {
VOVAL_IFLAG = new Double(split[342]);
}
if (!split[343].trim().isEmpty()) {
VOVLB = new Double(split[343]);
}
if (!split[344].trim().isEmpty()) {
VOVLB_I = new Double(split[344]);
}
if (!split[345].trim().isEmpty()) {
VOVLB_IFLAG = new Double(split[345]);
}
if (!split[346].trim().isEmpty()) {
VPERS2 = new Double(split[346]);
}
if (!split[347].trim().isEmpty()) {
VPERS3 = new Double(split[347]);
}
if (!split[348].trim().isEmpty()) {
VPERS4 = new Double(split[348]);
}
if (!split[349].trim().isEmpty()) {
VPERS5 = new Double(split[349]);
}
if (!split[350].trim().isEmpty()) {
VPERS6 = new Double(split[350]);
}
if (!split[351].trim().isEmpty()) {
VPERS6_I = new Double(split[351]);
}
if (!split[352].trim().isEmpty()) {
VPERS6_IFLAG = new Double(split[352]);
}
if (!split[353].trim().isEmpty()) {
VPERS = new Double(split[353]);
}
if (!split[354].trim().isEmpty()) {
VPERV = new Double(split[354]);
}
if (!split[355].trim().isEmpty()) {
VPERV_I = new Double(split[355]);
}
if (!split[356].trim().isEmpty()) {
VPERV_IFLAG = new Double(split[356]);
}
if (!split[357].trim().isEmpty()) {
VSHPCT2 = new Double(split[357]);
}
if (!split[358].trim().isEmpty()) {
VSHPCT3 = new Double(split[358]);
}
if (!split[359].trim().isEmpty()) {
VSHPCT4 = new Double(split[359]);
}
if (!split[360].trim().isEmpty()) {
VSHPCT5 = new Double(split[360]);
}
if (!split[361].trim().isEmpty()) {
VSHPCT = new Double(split[361]);
}
if (!split[362].trim().isEmpty()) {
VTYPE2 = new Double(split[362]);
}
if (!split[363].trim().isEmpty()) {
VTYPE2_I = new Double(split[363]);
}
if (!split[364].trim().isEmpty()) {
VTYPE2_IFLAG = new Double(split[364]);
}
if (!split[365].trim().isEmpty()) {
VTYPE = new Double(split[365]);
}
if (!split[366].trim().isEmpty()) {
VTYPE_I = new Double(split[366]);
}
if (!split[367].trim().isEmpty()) {
VTYPE_IFLAG = new Double(split[367]);
}
if (!split[368].trim().isEmpty()) {
ALLENDW = new Double(split[368]);
}
if (!split[369].trim().isEmpty()) {
ALLGD = new Double(split[369]);
}
if (!split[370].trim().isEmpty()) {
DVBLDDEBT = new Double(split[370]);
}
if (!split[371].trim().isEmpty()) {
DVBLDVAL = new Double(split[371]);
}
if (!split[372].trim().isEmpty()) {
DVCACRVAL_SUM = new Double(split[372]);
}
if (!split[373].trim().isEmpty()) {
DVCACTV_SUM = new Double(split[373]);
}
if (!split[374].trim().isEmpty()) {
DVCAODVAL_SUM = new Double(split[374]);
}
if (!split[375].trim().isEmpty()) {
DVCASVV_SUM = new Double(split[375]);
}
if (!split[376].trim().isEmpty()) {
DVCAVAL_SUM = new Double(split[376]);
}
if (!split[377].trim().isEmpty()) {
DVCISAV_SUM = new Double(split[377]);
}
if (!split[378].trim().isEmpty()) {
DVDBRWEALTHVAL_SUM = new Double(split[378]);
}
if (!split[379].trim().isEmpty()) {
DVEQHIP = new Double(split[379]);
}
if (!split[380].trim().isEmpty()) {
DVEQRELVAL = new Double(split[380]);
}
if (!split[381].trim().isEmpty()) {
DVEQRUPM = new Double(split[381]);
}
if (!split[382].trim().isEmpty()) {
DVFBONDV_SUM = new Double(split[382]);
}
if (!split[383].trim().isEmpty()) {
DVFCOLLV_SUM = new Double(split[383]);
}
if (!split[384].trim().isEmpty()) {
DVFESHARES_SUM = new Double(split[384]);
}
if (!split[385].trim().isEmpty()) {
DVFFASSETS_SUM = new Double(split[385]);
}
if (!split[386].trim().isEmpty()) {
DVFGLTFOV_SUM = new Double(split[386]);
}
if (!split[387].trim().isEmpty()) {
DVFGLTUKV_SUM = new Double(split[387]);
}
if (!split[388].trim().isEmpty()) {
DVFINFLV_SUM = new Double(split[388]);
}
if (!split[389].trim().isEmpty()) {
DVFINFVAL_SUM = new Double(split[389]);
}
if (!split[390].trim().isEmpty()) {
DVFINFV_SUM = new Double(split[390]);
}
if (!split[391].trim().isEmpty()) {
DVFINVOTV_SUM = new Double(split[391]);
}
if (!split[392].trim().isEmpty()) {
DVFNSVAL_SUM = new Double(split[392]);
}
if (!split[393].trim().isEmpty()) {
DVFSHOSV_SUM = new Double(split[393]);
}
if (!split[394].trim().isEmpty()) {
DVFSHUKV_SUM = new Double(split[394]);
}
if (!split[395].trim().isEmpty()) {
DVGCOLLV = new Double(split[395]);
}
if (!split[396].trim().isEmpty()) {
DVHORP = new Double(split[396]);
}
if (!split[397].trim().isEmpty()) {
DVHSEDEBT = new Double(split[397]);
}
if (!split[398].trim().isEmpty()) {
DVHSEVAL = new Double(split[398]);
}
if (!split[399].trim().isEmpty()) {
DVHVALUE = new Double(split[399]);
}
if (!split[400].trim().isEmpty()) {
DVIISAV_SUM = new Double(split[400]);
}
if (!split[401].trim().isEmpty()) {
DVINSV_SUM = new Double(split[401]);
}
if (!split[402].trim().isEmpty()) {
DVISAVAL_SUM = new Double(split[402]);
}
if (!split[403].trim().isEmpty()) {
DVKISAV_SUM = new Double(split[403]);
}
if (!split[404].trim().isEmpty()) {
DVLOSDEBT = new Double(split[404]);
}
if (!split[405].trim().isEmpty()) {
DVLOSVAL = new Double(split[405]);
}
if (!split[406].trim().isEmpty()) {
DVLUKDEBT = new Double(split[406]);
}
if (!split[407].trim().isEmpty()) {
DVLUKVAL = new Double(split[407]);
}
if (!split[408].trim().isEmpty()) {
DVOPRDEBT = new Double(split[408]);
}
if (!split[409].trim().isEmpty()) {
DVOPRVAL = new Double(split[409]);
}
if (!split[410].trim().isEmpty()) {
DVPAVCUV_SUM = new Double(split[410]);
}
if (!split[411].trim().isEmpty()) {
DVPEPV_SUM = new Double(split[411]);
}
if (!split[412].trim().isEmpty()) {
DVPFCURVAL_SUM = new Double(split[412]);
}
if (!split[413].trim().isEmpty()) {
DVPFDDV_SUM = new Double(split[413]);
}
if (!split[414].trim().isEmpty()) {
DVPINPVAL_SUM = new Double(split[414]);
}
if (!split[415].trim().isEmpty()) {
DVPPVAL_SUM = new Double(split[415]);
}
if (!split[416].trim().isEmpty()) {
DVPRIRNT = new Double(split[416]);
}
if (!split[417].trim().isEmpty()) {
DVPROPERTY = new Double(split[417]);
}
if (!split[418].trim().isEmpty()) {
DVSAVAL_SUM = new Double(split[418]);
}
if (!split[419].trim().isEmpty()) {
DVSPEN_SUM = new Double(split[419]);
}
if (!split[420].trim().isEmpty()) {
DVTOTCARVAL = new Double(split[420]);
}
if (!split[421].trim().isEmpty()) {
DVTOTMOTBVAL = new Double(split[421]);
}
if (!split[422].trim().isEmpty()) {
DVTOTOTHVEHVAL = new Double(split[422]);
}
if (!split[423].trim().isEmpty()) {
DVTOTPERNPVAL = new Double(split[423]);
}
if (!split[424].trim().isEmpty()) {
DVTOTVANVAL = new Double(split[424]);
}
if (!split[425].trim().isEmpty()) {
DVTOTVEHVAL = new Double(split[425]);
}
if (!split[426].trim().isEmpty()) {
DVVALDBT_SUM = new Double(split[426]);
}
if (!split[427].trim().isEmpty()) {
DVVALDCOS_SUM = new Double(split[427]);
}
if (!split[428].trim().isEmpty()) {
HFINL_SUM = new Double(split[428]);
}
if (!split[429].trim().isEmpty()) {
HFINW_EXCENDW_SUM = new Double(split[429]);
}
if (!split[430].trim().isEmpty()) {
HFINWNT_SUM = new Double(split[430]);
}
if (!split[431].trim().isEmpty()) {
HFINW_SUM = new Double(split[431]);
}
if (!split[432].trim().isEmpty()) {
HMORTG = new Double(split[432]);
}
if (!split[433].trim().isEmpty()) {
HOUSGDST_SUM = new Double(split[433]);
}
if (!split[434].trim().isEmpty()) {
HPARR_SUM = new Double(split[434]);
}
if (!split[435].trim().isEmpty()) {
HPHYSW = new Double(split[435]);
}
if (!split[436].trim().isEmpty()) {
HPROPW = new Double(split[436]);
}
if (!split[437].trim().isEmpty()) {
LANDOVSEAT_SUM = new Double(split[437]);
}
if (!split[438].trim().isEmpty()) {
LNARR_SUM = new Double(split[438]);
}
if (!split[439].trim().isEmpty()) {
MOARR_SUM = new Double(split[439]);
}
if (!split[440].trim().isEmpty()) {
T_FLNS_SUM = new Double(split[440]);
}
if (!split[441].trim().isEmpty()) {
T_LNS_SUM = new Double(split[441]);
}
if (!split[442].trim().isEmpty()) {
T_SLNS_SUM = new Double(split[442]);
}
if (!split[443].trim().isEmpty()) {
TOTBILLARR_SUM = new Double(split[443]);
}
if (!split[444].trim().isEmpty()) {
TOTCC_SUM = new Double(split[444]);
}
if (!split[445].trim().isEmpty()) {
TOTHP_SUM = new Double(split[445]);
}
if (!split[446].trim().isEmpty()) {
TOTLOS_SUM = new Double(split[446]);
}
if (!split[447].trim().isEmpty()) {
TOTMNEG = new Double(split[447]);
}
if (!split[448].trim().isEmpty()) {
TOTMORT = new Double(split[448]);
}
if (!split[449].trim().isEmpty()) {
TOTMO_SUM = new Double(split[449]);
}
if (!split[450].trim().isEmpty()) {
TOTMVAL = new Double(split[450]);
}
if (!split[451].trim().isEmpty()) {
TOTPEN_SUM = new Double(split[451]);
}
if (!split[452].trim().isEmpty()) {
TOTSC_SUM = new Double(split[452]);
}
if (!split[453].trim().isEmpty()) {
TOTWLTH = new Double(split[453]);
}
if (!split[454].trim().isEmpty()) {
DVHRPNUM = new Double(split[454]);
}
if (!split[455].trim().isEmpty()) {
DVHSIZE = new Double(split[455]);
}
if (!split[456].trim().isEmpty()) {
HHLDR = new Double(split[456]);
}
if (!split[457].trim().isEmpty()) {
HHOLDTYPE = new Double(split[457]);
}
if (!split[458].trim().isEmpty()) {
HRPDVAGE9 = new Double(split[458]);
}
if (!split[459].trim().isEmpty()) {
HRPDVILO3A = new Double(split[459]);
}
if (!split[460].trim().isEmpty()) {
HRPDVMRDF = new Double(split[460]);
}
if (!split[461].trim().isEmpty()) {
HRPEDATTN1 = new Double(split[461]);
}
if (!split[462].trim().isEmpty()) {
HRPEDATTN2 = new Double(split[462]);
}
if (!split[463].trim().isEmpty()) {
HRPEDATTN3 = new Double(split[463]);
}
if (!split[464].trim().isEmpty()) {
HRPEDLEVEL = new Double(split[464]);
}
if (!split[465].trim().isEmpty()) {
HRPEMPSTAT2 = new Double(split[465]);
}
if (!split[466].trim().isEmpty()) {
HRPIOUT1 = new Double(split[466]);
}
if (!split[467].trim().isEmpty()) {
HRPNSSEC3 = new Double(split[467]);
}
if (!split[468].trim().isEmpty()) {
HRPPARTIOUT1 = new Double(split[468]);
}
if (!split[469].trim().isEmpty()) {
HRPPART = new Double(split[469]);
}
if (!split[470].trim().isEmpty()) {
HRPSEX = new Double(split[470]);
}
if (!split[471].trim().isEmpty()) {
NBABY = new Double(split[471]);
}
if (!split[472].trim().isEmpty()) {
NC1015 = new Double(split[472]);
}
if (!split[473].trim().isEmpty()) {
NC1618 = new Double(split[473]);
}
if (!split[474].trim().isEmpty()) {
NC5TO9 = new Double(split[474]);
}
if (!split[475].trim().isEmpty()) {
NCHILD = new Double(split[475]);
}
if (!split[476].trim().isEmpty()) {
NCU16 = new Double(split[476]);
}
if (!split[477].trim().isEmpty()) {
NCUND5 = new Double(split[477]);
}
if (!split[478].trim().isEmpty()) {
NDEPC = new Double(split[478]);
}
if (!split[479].trim().isEmpty()) {
NNDEPC = new Double(split[479]);
}
if (!split[480].trim().isEmpty()) {
NUMADULT = new Double(split[480]);
}
if (!split[481].trim().isEmpty()) {
NUMCH18 = new Double(split[481]);
}
if (!split[482].trim().isEmpty()) {
NUMCHILD = new Double(split[482]);
}
if (!split[483].trim().isEmpty()) {
NUMCPART = new Double(split[483]);
}
if (!split[484].trim().isEmpty()) {
NUMDEPCH = new Double(split[484]);
}
if (!split[485].trim().isEmpty()) {
NUMHHLDR = new Double(split[485]);
}
if (!split[486].trim().isEmpty()) {
NUMJOB = new Double(split[486]);
}
if (!split[487].trim().isEmpty()) {
NUMMPART = new Double(split[487]);
}
if (!split[488].trim().isEmpty()) {
NUMSSEX = new Double(split[488]);
}
if (!split[489].trim().isEmpty()) {
VESTV3_IFLAG = new Double(split[489]);
}
if (!split[490].trim().isEmpty()) {
VESVB3 = new Double(split[490]);
}
if (!split[491].trim().isEmpty()) {
VESTV3 = new Double(split[491]);
}
if (!split[492].trim().isEmpty()) {
VESTV3_I = new Double(split[492]);
}
if (!split[493].trim().isEmpty()) {
HRPDVAGE15 = new Double(split[493]);
}
if (!split[494].trim().isEmpty()) {
HBEDRM = new Double(split[494]);
}
if (!split[495].trim().isEmpty()) {
CASEW1 = new Double(split[495]);
}
if (!split[496].trim().isEmpty()) {
HRPDVAGEW1BAND = new Double(split[496]);
}
if (!split[497].trim().isEmpty()) {
GOR = new Double(split[497]);
}
if (!split[498].trim().isEmpty()) {
YEAR = new Double(split[498]);
}
if (!split[499].trim().isEmpty()) {
MONTH = new Double(split[499]);
}
}
}
