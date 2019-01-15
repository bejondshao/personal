package org.bejond.wholetest.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;

public class ChineseName {
	public static void main(String[] args) {
		String sgy = "上官雨";
		String qly = "丘陵雨";
		String qfy = "乞伏雨";
		String mqys = "万俟雨生";
		String csy = "褚师雨";
		String shm = "宋海一";
		String py = "shangguanyu";
		System.out.println(HanLP.segment(sgy)); // [上官雨/nr] 整体识别为人名
		System.out.println(HanLP.segment(qly)); // [丘陵/n, 雨/n] 识别为两个名词
		System.out.println(HanLP.segment(qfy)); // [乞/n, 伏/q, 雨/n] 未识别成人名
		System.out.println(HanLP.segment(mqys)); // [万/m, 俟/x, 雨/n, 生/v] 未识别成人名
		System.out.println(HanLP.segment(csy)); // [褚师雨/nr] 整体识别为人名
		System.out.println(HanLP.segment(shm)); // [褚师雨/nr] 整体识别为人名
		System.out.println(HanLP.segment(py)); // [褚师雨/nr] 整体识别为人名
		CustomDictionary.add("上官");
		CustomDictionary.add("万俟");
		CustomDictionary.add("乞伏");
		CustomDictionary.add("shangguan");
		CustomDictionary.insert("褚师", "nr 1024");
		HanLP.Config.ShowTermNature = false;
		System.out.println(HanLP.segment(sgy)); // [上官, 雨] 拆分
		System.out.println(HanLP.segment(qly)); // [丘陵, 雨] 拆分
		System.out.println(HanLP.segment(qfy)); // [乞伏, 雨] 拆分
		System.out.println(HanLP.segment(mqys)); // [万俟, 雨, 生] 拆分，但分成三个词
		System.out.println(HanLP.segment(csy)); // 200, [褚师雨]，1024，拆分为[褚师, 雨]
		System.out.println(HanLP.segment(shm)); // 200, [褚师雨]，1024，拆分为[褚师, 雨]
		System.out.println(HanLP.segment(py)); // 200, [褚师雨]，1024，拆分为[褚师, 雨]

		System.out.println(HanLP.convertToPinyinString(sgy, ",", false)); // shang,guan,yu 挨个字拆分成拼音
		System.out.println(HanLP.convertToPinyinString(qly, ",", false)); // qiu,ling,yu 挨个字拆分成拼音
		System.out.println(HanLP.convertToPinyinString(qfy, ",", false)); // qi,fu,yu 挨个字拆分成拼音
		System.out.println(HanLP.convertToPinyinString(mqys, ",", false)); // mo,qi,yu,sheng 挨个字拆分成拼音，拼音词典里有“万俟”
		System.out.println(HanLP.convertToPinyinList(mqys)); // [mo4, qi2, yu3, sheng1] 挨个字拆分成拼音，拼音词典里有“万俟”，带音标
		System.out.println(HanLP.convertToPinyinList("重")); // [mo4, qi2, yu3, sheng1] 挨个字拆分成拼音，拼音词典里有“万俟”，带音标
		System.out.println(HanLP.convertToPinyinFirstCharString(mqys, ",", false)); // m,q,y,s 挨个字拆分成拼音，拼音词典里有“万俟”，只有声母
	}
}
