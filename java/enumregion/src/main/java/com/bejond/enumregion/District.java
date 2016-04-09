package com.bejond.enumregion;

/**
 * Created by bejond on 4/9/16.
 * From https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD%E5%8E%BF%E7%BA%A7%E4%BB%A5%E4%B8%8A%E8%A1%8C%E6%94%BF%E5%8C%BA%E5%88%97%E8%A1%A8
 */

public interface District {

	// 注意, 只有常量用汉字, 类型仍然用英文

	enum Beijing implements District {
		东城区, 西城区, 朝阳区, 丰台区, 石景山区, 海淀区, 门头沟区, 房山区, 通州区,
		顺义区, 昌平区, 大兴区, 怀柔区, 平谷区, 密云区, 延庆区
	}

	enum Tianjin implements District {
		河西区, 河东区, 和平区, 南开区, 河北区, 红桥区, 东丽区, 西青区, 津南区,
		北辰区, 武清区, 宝坻区, 宁河区, 静海区, 滨海新区, 蓟县
	};

	enum Shanghai implements District {
		黄浦区, 徐汇区, 长宁区, 静安区, 普陀区, 虹口区, 杨浦区, 闵行区, 宝山区,
		嘉定区, 浦东新区, 金山区, 松江区, 青浦区, 奉贤区崇明县
	}

	enum Chongqing implements District {
		渝中区, 大渡口区, 江北区, 南岸区, 北碚区, 渝北区, 巴南区, 长寿区, 沙坪坝区,
		万州区, 涪陵区, 黔江区, 永川区, 合川区, 江津区, 九龙坡区, 南川区, 綦江区,
		大足区, 璧山区, 铜梁区, 荣昌区, 潼南区, 梁平县, 开县, 忠县, 城口县, 垫江县,
		武隆县, 丰都县, 奉节县, 云阳县, 巫溪县, 巫山县, 石柱土家族自治县,
		秀山土家族苗族自治县, 酉阳土家族苗族自治县, 彭水苗族土家族自治县

	}

	enum Shenyang implements District {
		沈河区, 和平区, 大东区, 皇姑区, 铁西区, 苏家屯区, 浑南区, 沈北新区, 于洪区,
		辽中区, 新民市, 康平县, 法库县
	};

	enum Dalian implements District {
		西岗区, 中山区, 沙河口区, 甘井子区, 旅顺口区, 金州区, 普兰店区, 瓦房店市,
		庄河市, 长海县
	};

	enum Shijiazhuang implements District {
		长安区, 桥西区, 新华区, 裕华区, 井陉矿区, 藁城区, 鹿泉区, 栾城区, 晋州市,
		新乐市, 井陉县, 正定县, 行唐县, 灵寿县, 高邑县, 深泽县, 赞皇县, 无极县,
		平山县, 元氏县, 赵县
	}

	enum Xiamen implements District {
		思明区, 海沧区, 湖里区, 集美区, 同安区, 翔安区
	}

	// 剩下的自己补吧, 特殊地区根据业务自行补充
}
