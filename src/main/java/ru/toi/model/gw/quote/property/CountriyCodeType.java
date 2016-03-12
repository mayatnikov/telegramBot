
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CountriyCode_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CountriyCode_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RU"/>
 *     &lt;enumeration value="BY"/>
 *     &lt;enumeration value="KZ"/>
 *     &lt;enumeration value="UA"/>
 *     &lt;enumeration value="AN"/>
 *     &lt;enumeration value="AB"/>
 *     &lt;enumeration value="AU"/>
 *     &lt;enumeration value="AT"/>
 *     &lt;enumeration value="AZ"/>
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="DZ"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="AI"/>
 *     &lt;enumeration value="AO"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="AQ"/>
 *     &lt;enumeration value="AG"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="AM"/>
 *     &lt;enumeration value="AW"/>
 *     &lt;enumeration value="AF"/>
 *     &lt;enumeration value="BS"/>
 *     &lt;enumeration value="BD"/>
 *     &lt;enumeration value="BB"/>
 *     &lt;enumeration value="BH"/>
 *     &lt;enumeration value="BZ"/>
 *     &lt;enumeration value="BE"/>
 *     &lt;enumeration value="BJ"/>
 *     &lt;enumeration value="BM"/>
 *     &lt;enumeration value="BG"/>
 *     &lt;enumeration value="BO"/>
 *     &lt;enumeration value="BQ"/>
 *     &lt;enumeration value="BA"/>
 *     &lt;enumeration value="BW"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="IO"/>
 *     &lt;enumeration value="BN"/>
 *     &lt;enumeration value="BF"/>
 *     &lt;enumeration value="BI"/>
 *     &lt;enumeration value="BT"/>
 *     &lt;enumeration value="VU"/>
 *     &lt;enumeration value="HU"/>
 *     &lt;enumeration value="VE"/>
 *     &lt;enumeration value="VG"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="VN"/>
 *     &lt;enumeration value="GA"/>
 *     &lt;enumeration value="HT"/>
 *     &lt;enumeration value="GY"/>
 *     &lt;enumeration value="GM"/>
 *     &lt;enumeration value="GH"/>
 *     &lt;enumeration value="GP"/>
 *     &lt;enumeration value="GT"/>
 *     &lt;enumeration value="GN"/>
 *     &lt;enumeration value="GW"/>
 *     &lt;enumeration value="DE"/>
 *     &lt;enumeration value="GG"/>
 *     &lt;enumeration value="GI"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="HK"/>
 *     &lt;enumeration value="GD"/>
 *     &lt;enumeration value="GL"/>
 *     &lt;enumeration value="GR"/>
 *     &lt;enumeration value="GE"/>
 *     &lt;enumeration value="GU"/>
 *     &lt;enumeration value="DK"/>
 *     &lt;enumeration value="JE"/>
 *     &lt;enumeration value="DJ"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="DO"/>
 *     &lt;enumeration value="EG"/>
 *     &lt;enumeration value="ZM"/>
 *     &lt;enumeration value="EH"/>
 *     &lt;enumeration value="ZW"/>
 *     &lt;enumeration value="IL"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="ID"/>
 *     &lt;enumeration value="JO"/>
 *     &lt;enumeration value="IQ"/>
 *     &lt;enumeration value="IR"/>
 *     &lt;enumeration value="IE"/>
 *     &lt;enumeration value="IS"/>
 *     &lt;enumeration value="ES"/>
 *     &lt;enumeration value="IT"/>
 *     &lt;enumeration value="YE"/>
 *     &lt;enumeration value="CV"/>
 *     &lt;enumeration value="KH"/>
 *     &lt;enumeration value="CM"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="QA"/>
 *     &lt;enumeration value="KE"/>
 *     &lt;enumeration value="CY"/>
 *     &lt;enumeration value="KG"/>
 *     &lt;enumeration value="KI"/>
 *     &lt;enumeration value="CN"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="CO"/>
 *     &lt;enumeration value="KM"/>
 *     &lt;enumeration value="CG"/>
 *     &lt;enumeration value="CD"/>
 *     &lt;enumeration value="KP"/>
 *     &lt;enumeration value="KR"/>
 *     &lt;enumeration value="CR"/>
 *     &lt;enumeration value="CI"/>
 *     &lt;enumeration value="CU"/>
 *     &lt;enumeration value="KW"/>
 *     &lt;enumeration value="CW"/>
 *     &lt;enumeration value="LA"/>
 *     &lt;enumeration value="LV"/>
 *     &lt;enumeration value="LS"/>
 *     &lt;enumeration value="LR"/>
 *     &lt;enumeration value="LB"/>
 *     &lt;enumeration value="LY"/>
 *     &lt;enumeration value="LT"/>
 *     &lt;enumeration value="LI"/>
 *     &lt;enumeration value="LU"/>
 *     &lt;enumeration value="MU"/>
 *     &lt;enumeration value="MR"/>
 *     &lt;enumeration value="MG"/>
 *     &lt;enumeration value="YT"/>
 *     &lt;enumeration value="MO"/>
 *     &lt;enumeration value="MW"/>
 *     &lt;enumeration value="MY"/>
 *     &lt;enumeration value="ML"/>
 *     &lt;enumeration value="UM"/>
 *     &lt;enumeration value="MV"/>
 *     &lt;enumeration value="MT"/>
 *     &lt;enumeration value="MA"/>
 *     &lt;enumeration value="MQ"/>
 *     &lt;enumeration value="MH"/>
 *     &lt;enumeration value="MX"/>
 *     &lt;enumeration value="FM"/>
 *     &lt;enumeration value="MZ"/>
 *     &lt;enumeration value="MD"/>
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="MN"/>
 *     &lt;enumeration value="MS"/>
 *     &lt;enumeration value="MM"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="NR"/>
 *     &lt;enumeration value="NP"/>
 *     &lt;enumeration value="NE"/>
 *     &lt;enumeration value="NG"/>
 *     &lt;enumeration value="NL"/>
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="NU"/>
 *     &lt;enumeration value="NZ"/>
 *     &lt;enumeration value="NC"/>
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="AE"/>
 *     &lt;enumeration value="OM"/>
 *     &lt;enumeration value="KY"/>
 *     &lt;enumeration value="CK"/>
 *     &lt;enumeration value="TC"/>
 *     &lt;enumeration value="BV"/>
 *     &lt;enumeration value="IM"/>
 *     &lt;enumeration value="NF"/>
 *     &lt;enumeration value="CX"/>
 *     &lt;enumeration value="HM"/>
 *     &lt;enumeration value="PK"/>
 *     &lt;enumeration value="PW"/>
 *     &lt;enumeration value="PS"/>
 *     &lt;enumeration value="PA"/>
 *     &lt;enumeration value="VA"/>
 *     &lt;enumeration value="PG"/>
 *     &lt;enumeration value="PY"/>
 *     &lt;enumeration value="PE"/>
 *     &lt;enumeration value="PN"/>
 *     &lt;enumeration value="PL"/>
 *     &lt;enumeration value="PT"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="MK"/>
 *     &lt;enumeration value="RE"/>
 *     &lt;enumeration value="RW"/>
 *     &lt;enumeration value="RO"/>
 *     &lt;enumeration value="WS"/>
 *     &lt;enumeration value="SM"/>
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="SA"/>
 *     &lt;enumeration value="SZ"/>
 *     &lt;enumeration value="MP"/>
 *     &lt;enumeration value="SC"/>
 *     &lt;enumeration value="BL"/>
 *     &lt;enumeration value="SN"/>
 *     &lt;enumeration value="MF"/>
 *     &lt;enumeration value="SX"/>
 *     &lt;enumeration value="PM"/>
 *     &lt;enumeration value="VC"/>
 *     &lt;enumeration value="KN"/>
 *     &lt;enumeration value="LC"/>
 *     &lt;enumeration value="RS"/>
 *     &lt;enumeration value="SG"/>
 *     &lt;enumeration value="SY"/>
 *     &lt;enumeration value="SK"/>
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="GB"/>
 *     &lt;enumeration value="US"/>
 *     &lt;enumeration value="SB"/>
 *     &lt;enumeration value="SO"/>
 *     &lt;enumeration value="SD"/>
 *     &lt;enumeration value="SR"/>
 *     &lt;enumeration value="SL"/>
 *     &lt;enumeration value="TJ"/>
 *     &lt;enumeration value="TH"/>
 *     &lt;enumeration value="TW"/>
 *     &lt;enumeration value="TZ"/>
 *     &lt;enumeration value="TL"/>
 *     &lt;enumeration value="TG"/>
 *     &lt;enumeration value="TK"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="TT"/>
 *     &lt;enumeration value="TV"/>
 *     &lt;enumeration value="TN"/>
 *     &lt;enumeration value="TM"/>
 *     &lt;enumeration value="TR"/>
 *     &lt;enumeration value="UG"/>
 *     &lt;enumeration value="UZ"/>
 *     &lt;enumeration value="WF"/>
 *     &lt;enumeration value="UY"/>
 *     &lt;enumeration value="FO"/>
 *     &lt;enumeration value="FJ"/>
 *     &lt;enumeration value="PH"/>
 *     &lt;enumeration value="FI"/>
 *     &lt;enumeration value="FK"/>
 *     &lt;enumeration value="FR"/>
 *     &lt;enumeration value="GF"/>
 *     &lt;enumeration value="PF"/>
 *     &lt;enumeration value="TF"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="CF"/>
 *     &lt;enumeration value="TD"/>
 *     &lt;enumeration value="ME"/>
 *     &lt;enumeration value="CZ"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CH"/>
 *     &lt;enumeration value="SE"/>
 *     &lt;enumeration value="SJ"/>
 *     &lt;enumeration value="LK"/>
 *     &lt;enumeration value="EC"/>
 *     &lt;enumeration value="GQ"/>
 *     &lt;enumeration value="AX"/>
 *     &lt;enumeration value="SV"/>
 *     &lt;enumeration value="ER"/>
 *     &lt;enumeration value="EE"/>
 *     &lt;enumeration value="ET"/>
 *     &lt;enumeration value="ZA"/>
 *     &lt;enumeration value="GS"/>
 *     &lt;enumeration value="OS"/>
 *     &lt;enumeration value="SS"/>
 *     &lt;enumeration value="JM"/>
 *     &lt;enumeration value="JP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountriyCode_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum CountriyCodeType {


    /**
     * РОССИЯ
     * 
     */
    RU,

    /**
     * БЕЛАРУСЬ
     * 
     */
    BY,

    /**
     * КАЗАХСТАН
     * 
     */
    KZ,

    /**
     * УКРАИНА
     * 
     */
    UA,

    /**
     * Netherlands Antilles
     * 
     */
    AN,

    /**
     * АБХАЗИЯ
     * 
     */
    AB,

    /**
     * АВСТРАЛИЯ
     * 
     */
    AU,

    /**
     * АВСТРИЯ
     * 
     */
    AT,

    /**
     * АЗЕРБАЙДЖАН
     * 
     */
    AZ,

    /**
     * АЛБАНИЯ
     * 
     */
    AL,

    /**
     * АЛЖИР
     * 
     */
    DZ,

    /**
     * АМЕРИКАНСКОЕ САМОА
     * 
     */
    AS,

    /**
     * АНГИЛЬЯ
     * 
     */
    AI,

    /**
     * АНГОЛА
     * 
     */
    AO,

    /**
     * АНДОРРА
     * 
     */
    AD,

    /**
     * АНТАРКТИДА
     * 
     */
    AQ,

    /**
     * АНТИГУА И БАРБУДА
     * 
     */
    AG,

    /**
     * АРГЕНТИНА
     * 
     */
    AR,

    /**
     * АРМЕНИЯ
     * 
     */
    AM,

    /**
     * АРУБА
     * 
     */
    AW,

    /**
     * АФГАНИСТАН
     * 
     */
    AF,

    /**
     * БАГАМЫ
     * 
     */
    BS,

    /**
     * БАНГЛАДЕШ
     * 
     */
    BD,

    /**
     * БАРБАДОС
     * 
     */
    BB,

    /**
     * БАХРЕЙН
     * 
     */
    BH,

    /**
     * БЕЛИЗ
     * 
     */
    BZ,

    /**
     * БЕЛЬГИЯ
     * 
     */
    BE,

    /**
     * БЕНИН
     * 
     */
    BJ,

    /**
     * БЕРМУДЫ
     * 
     */
    BM,

    /**
     * БОЛГАРИЯ
     * 
     */
    BG,

    /**
     * БОЛИВИЯ, МНОГОНАЦИОНАЛЬНОЕ ГОСУДАРСТВО
     * 
     */
    BO,

    /**
     * БОНЭЙР, СИНТ-ЭСТАТИУС И САБА
     * 
     */
    BQ,

    /**
     * БОСНИЯ И ГЕРЦЕГОВИНА
     * 
     */
    BA,

    /**
     * БОТСВАНА
     * 
     */
    BW,

    /**
     * БРАЗИЛИЯ
     * 
     */
    BR,

    /**
     * БРИТАНСКАЯ ТЕРРИТОРИЯ В ИНДИЙСКОМ ОКЕАНЕ
     * 
     */
    IO,

    /**
     * БРУНЕЙ-ДАРУССАЛАМ
     * 
     */
    BN,

    /**
     * БУРКИНА-ФАСО
     * 
     */
    BF,

    /**
     * БУРУНДИ
     * 
     */
    BI,

    /**
     * БУТАН
     * 
     */
    BT,

    /**
     * ВАНУАТУ
     * 
     */
    VU,

    /**
     * ВЕНГРИЯ
     * 
     */
    HU,

    /**
     * ВЕНЕСУЭЛА БОЛИВАРИАНСКАЯ РЕСПУБЛИКА
     * 
     */
    VE,

    /**
     * ВИРГИНСКИЕ ОСТРОВА, БРИТАНСКИЕ
     * 
     */
    VG,

    /**
     * ВИРГИНСКИЕ ОСТРОВА, США
     * 
     */
    VI,

    /**
     * ВЬЕТНАМ
     * 
     */
    VN,

    /**
     * ГАБОН
     * 
     */
    GA,

    /**
     * ГАИТИ
     * 
     */
    HT,

    /**
     * ГАЙАНА
     * 
     */
    GY,

    /**
     * ГАМБИЯ
     * 
     */
    GM,

    /**
     * ГАНА
     * 
     */
    GH,

    /**
     * ГВАДЕЛУПА
     * 
     */
    GP,

    /**
     * ГВАТЕМАЛА
     * 
     */
    GT,

    /**
     * ГВИНЕЯ
     * 
     */
    GN,

    /**
     * ГВИНЕЯ-БИСАУ
     * 
     */
    GW,

    /**
     * ГЕРМАНИЯ
     * 
     */
    DE,

    /**
     * ГЕРНСИ
     * 
     */
    GG,

    /**
     * ГИБРАЛТАР
     * 
     */
    GI,

    /**
     * ГОНДУРАС
     * 
     */
    HN,

    /**
     * ГОНКОНГ
     * 
     */
    HK,

    /**
     * ГРЕНАДА
     * 
     */
    GD,

    /**
     * ГРЕНЛАНДИЯ
     * 
     */
    GL,

    /**
     * ГРЕЦИЯ
     * 
     */
    GR,

    /**
     * ГРУЗИЯ
     * 
     */
    GE,

    /**
     * ГУАМ
     * 
     */
    GU,

    /**
     * ДАНИЯ
     * 
     */
    DK,

    /**
     * ДЖЕРСИ
     * 
     */
    JE,

    /**
     * ДЖИБУТИ
     * 
     */
    DJ,

    /**
     * ДОМИНИКА
     * 
     */
    DM,

    /**
     * ДОМИНИКАНСКАЯ РЕСПУБЛИКА
     * 
     */
    DO,

    /**
     * ЕГИПЕТ
     * 
     */
    EG,

    /**
     * ЗАМБИЯ
     * 
     */
    ZM,

    /**
     * ЗАПАДНАЯ САХАРА Росстандарта от 14.12.2011 N 1514-ст
     * 
     */
    EH,

    /**
     * ЗИМБАБВЕ
     * 
     */
    ZW,

    /**
     * ИЗРАИЛЬ
     * 
     */
    IL,

    /**
     * ИНДИЯ
     * 
     */
    IN,

    /**
     * ИНДОНЕЗИЯ
     * 
     */
    ID,

    /**
     * ИОРДАНИЯ
     * 
     */
    JO,

    /**
     * ИРАК
     * 
     */
    IQ,

    /**
     * ИРАН, ИСЛАМСКАЯ РЕСПУБЛИКА
     * 
     */
    IR,

    /**
     * ИРЛАНДИЯ
     * 
     */
    IE,

    /**
     * ИСЛАНДИЯ
     * 
     */
    IS,

    /**
     * ИСПАНИЯ
     * 
     */
    ES,

    /**
     * ИТАЛИЯ
     * 
     */
    IT,

    /**
     * ЙЕМЕН
     * 
     */
    YE,

    /**
     * КАБО-ВЕРДЕ
     * 
     */
    CV,

    /**
     * КАМБОДЖА
     * 
     */
    KH,

    /**
     * КАМЕРУН
     * 
     */
    CM,

    /**
     * КАНАДА
     * 
     */
    CA,

    /**
     * КАТАР
     * 
     */
    QA,

    /**
     * КЕНИЯ
     * 
     */
    KE,

    /**
     * КИПР
     * 
     */
    CY,

    /**
     * КИРГИЗИЯ
     * 
     */
    KG,

    /**
     * КИРИБАТИ
     * 
     */
    KI,

    /**
     * КИТАЙ
     * 
     */
    CN,

    /**
     * КОКОСОВЫЕ (КИЛИНГ) ОСТРОВА
     * 
     */
    CC,

    /**
     * КОЛУМБИЯ
     * 
     */
    CO,

    /**
     * КОМОРЫ
     * 
     */
    KM,

    /**
     * КОНГО
     * 
     */
    CG,

    /**
     * КОНГО, ДЕМОКРАТИЧЕСКАЯ РЕСПУБЛИКА
     * 
     */
    CD,

    /**
     * КОРЕЯ, НАРОДНО-ДЕМОКРАТИЧЕСКАЯ РЕСПУБЛИКА
     * 
     */
    KP,

    /**
     * КОРЕЯ, РЕСПУБЛИКА
     * 
     */
    KR,

    /**
     * КОСТА-РИКА
     * 
     */
    CR,

    /**
     * КОТ Д'ИВУАР
     * 
     */
    CI,

    /**
     * КУБА
     * 
     */
    CU,

    /**
     * КУВЕЙТ
     * 
     */
    KW,

    /**
     * КЮРАСАО
     * 
     */
    CW,

    /**
     * ЛАОССКАЯ НАРОДНО-ДЕМОКРАТИЧЕСКАЯ РЕСПУБЛИКА
     * 
     */
    LA,

    /**
     * ЛАТВИЯ
     * 
     */
    LV,

    /**
     * ЛЕСОТО
     * 
     */
    LS,

    /**
     * ЛИБЕРИЯ
     * 
     */
    LR,

    /**
     * ЛИВАН
     * 
     */
    LB,

    /**
     * ЛИВИЯ
     * 
     */
    LY,

    /**
     * ЛИТВА
     * 
     */
    LT,

    /**
     * ЛИХТЕНШТЕЙН
     * 
     */
    LI,

    /**
     * ЛЮКСЕМБУРГ
     * 
     */
    LU,

    /**
     * МАВРИКИЙ
     * 
     */
    MU,

    /**
     * МАВРИТАНИЯ
     * 
     */
    MR,

    /**
     * МАДАГАСКАР
     * 
     */
    MG,

    /**
     * МАЙОТТА
     * 
     */
    YT,

    /**
     * МАКАО
     * 
     */
    MO,

    /**
     * МАЛАВИ
     * 
     */
    MW,

    /**
     * МАЛАЙЗИЯ
     * 
     */
    MY,

    /**
     * МАЛИ
     * 
     */
    ML,

    /**
     * МАЛЫЕ ТИХООКЕАНСКИЕ ОТДАЛЕННЫЕ ОСТРОВА СОЕДИНЕННЫХ ШТАТОВ
     * 
     */
    UM,

    /**
     * МАЛЬДИВЫ
     * 
     */
    MV,

    /**
     * МАЛЬТА
     * 
     */
    MT,

    /**
     * МАРОККО
     * 
     */
    MA,

    /**
     * МАРТИНИКА
     * 
     */
    MQ,

    /**
     * МАРШАЛЛОВЫ ОСТРОВА
     * 
     */
    MH,

    /**
     * МЕКСИКА
     * 
     */
    MX,

    /**
     * МИКРОНЕЗИЯ, ФЕДЕРАТИВНЫЕ ШТАТЫ
     * 
     */
    FM,

    /**
     * МОЗАМБИК
     * 
     */
    MZ,

    /**
     * МОЛДОВА, РЕСПУБЛИКА
     * 
     */
    MD,

    /**
     * МОНАКО
     * 
     */
    MC,

    /**
     * МОНГОЛИЯ
     * 
     */
    MN,

    /**
     * МОНТСЕРРАТ
     * 
     */
    MS,

    /**
     * МЬЯНМА
     * 
     */
    MM,

    /**
     * НАМИБИЯ
     * 
     */
    NA,

    /**
     * НАУРУ
     * 
     */
    NR,

    /**
     * НЕПАЛ
     * 
     */
    NP,

    /**
     * НИГЕР
     * 
     */
    NE,

    /**
     * НИГЕРИЯ
     * 
     */
    NG,

    /**
     * НИДЕРЛАНДЫ
     * 
     */
    NL,

    /**
     * НИКАРАГУА
     * 
     */
    NI,

    /**
     * НИУЭ
     * 
     */
    NU,

    /**
     * НОВАЯ ЗЕЛАНДИЯ
     * 
     */
    NZ,

    /**
     * НОВАЯ КАЛЕДОНИЯ
     * 
     */
    NC,

    /**
     * НОРВЕГИЯ
     * 
     */
    NO,

    /**
     * ОБЪЕДИНЕННЫЕ АРАБСКИЕ ЭМИРАТЫ
     * 
     */
    AE,

    /**
     * ОМАН
     * 
     */
    OM,

    /**
     * ОСТРОВА КАЙМАН
     * 
     */
    KY,

    /**
     * ОСТРОВА КУКА
     * 
     */
    CK,

    /**
     * ОСТРОВА ТЕРКС И КАЙКОС
     * 
     */
    TC,

    /**
     * ОСТРОВ БУВЕ
     * 
     */
    BV,

    /**
     * ОСТРОВ МЭН
     * 
     */
    IM,

    /**
     * ОСТРОВ НОРФОЛК
     * 
     */
    NF,

    /**
     * ОСТРОВ РОЖДЕСТВА
     * 
     */
    CX,

    /**
     * ОСТРОВ ХЕРД И ОСТРОВА МАКДОНАЛЬД
     * 
     */
    HM,

    /**
     * ПАКИСТАН
     * 
     */
    PK,

    /**
     * ПАЛАУ
     * 
     */
    PW,

    /**
     * ПАЛЕСТИНСКАЯ ТЕРРИТОРИЯ, ОККУПИРОВАННАЯ
     * 
     */
    PS,

    /**
     * ПАНАМА
     * 
     */
    PA,

    /**
     * ПАПСКИЙ ПРЕСТОЛ (ГОСУДАРСТВО - ГОРОД ВАТИКАН)
     * 
     */
    VA,

    /**
     * ПАПУА-НОВАЯ ГВИНЕЯ
     * 
     */
    PG,

    /**
     * ПАРАГВАЙ
     * 
     */
    PY,

    /**
     * ПЕРУ
     * 
     */
    PE,

    /**
     * ПИТКЕРН
     * 
     */
    PN,

    /**
     * ПОЛЬША
     * 
     */
    PL,

    /**
     * ПОРТУГАЛИЯ
     * 
     */
    PT,

    /**
     * ПУЭРТО-РИКО
     * 
     */
    PR,

    /**
     * РЕСПУБЛИКА МАКЕДОНИЯ
     * 
     */
    MK,

    /**
     * РЕЮНЬОН
     * 
     */
    RE,

    /**
     * РУАНДА
     * 
     */
    RW,

    /**
     * РУМЫНИЯ
     * 
     */
    RO,

    /**
     * САМОА
     * 
     */
    WS,

    /**
     * САН-МАРИНО
     * 
     */
    SM,

    /**
     * САН-ТОМЕ И ПРИНСИПИ
     * 
     */
    ST,

    /**
     * САУДОВСКАЯ АРАВИЯ
     * 
     */
    SA,

    /**
     * СВАЗИЛЕНД
     * 
     */
    SZ,

    /**
     * СЕВЕРНЫЕ МАРИАНСКИЕ ОСТРОВА
     * 
     */
    MP,

    /**
     * СЕЙШЕЛЫ
     * 
     */
    SC,

    /**
     * СЕН-БАРТЕЛЕМИ
     * 
     */
    BL,

    /**
     * СЕНЕГАЛ
     * 
     */
    SN,

    /**
     * СЕН-МАРТЕН
     * 
     */
    MF,

    /**
     * СЕН-МАРТЕН (нидерландская часть)
     * 
     */
    SX,

    /**
     * СЕН-ПЬЕР И МИКЕЛОН
     * 
     */
    PM,

    /**
     * СЕНТ-ВИНСЕНТ И ГРЕНАДИНЫ
     * 
     */
    VC,

    /**
     * СЕНТ-КИТС И НЕВИС
     * 
     */
    KN,

    /**
     * СЕНТ-ЛЮСИЯ
     * 
     */
    LC,

    /**
     * СЕРБИЯ
     * 
     */
    RS,

    /**
     * СИНГАПУР
     * 
     */
    SG,

    /**
     * СИРИЙСКАЯ АРАБСКАЯ РЕСПУБЛИКА
     * 
     */
    SY,

    /**
     * СЛОВАКИЯ
     * 
     */
    SK,

    /**
     * СЛОВЕНИЯ
     * 
     */
    SI,

    /**
     * СОЕДИНЕННОЕ КОРОЛЕВСТВО
     * 
     */
    GB,

    /**
     * СОЕДИНЕННЫЕ ШТАТЫ
     * 
     */
    US,

    /**
     * СОЛОМОНОВЫ ОСТРОВА
     * 
     */
    SB,

    /**
     * СОМАЛИ
     * 
     */
    SO,

    /**
     * СУДАН
     * 
     */
    SD,

    /**
     * СУРИНАМ
     * 
     */
    SR,

    /**
     * СЬЕРРА-ЛЕОНЕ
     * 
     */
    SL,

    /**
     * ТАДЖИКИСТАН
     * 
     */
    TJ,

    /**
     * ТАИЛАНД
     * 
     */
    TH,

    /**
     * ТАЙВАНЬ (КИТАЙ)
     * 
     */
    TW,

    /**
     * ТАНЗАНИЯ, ОБЪЕДИНЕННАЯ РЕСПУБЛИКА
     * 
     */
    TZ,

    /**
     * ТИМОР-ЛЕСТЕ
     * 
     */
    TL,

    /**
     * ТОГО
     * 
     */
    TG,

    /**
     * ТОКЕЛАУ
     * 
     */
    TK,

    /**
     * ТОНГА
     * 
     */
    TO,

    /**
     * ТРИНИДАД И ТОБАГО
     * 
     */
    TT,

    /**
     * ТУВАЛУ
     * 
     */
    TV,

    /**
     * ТУНИС
     * 
     */
    TN,

    /**
     * ТУРКМЕНИЯ
     * 
     */
    TM,

    /**
     * ТУРЦИЯ
     * 
     */
    TR,

    /**
     * УГАНДА
     * 
     */
    UG,

    /**
     * УЗБЕКИСТАН
     * 
     */
    UZ,

    /**
     * УОЛЛИС И ФУТУНА
     * 
     */
    WF,

    /**
     * УРУГВАЙ
     * 
     */
    UY,

    /**
     * ФАРЕРСКИЕ ОСТРОВА
     * 
     */
    FO,

    /**
     * ФИДЖИ
     * 
     */
    FJ,

    /**
     * ФИЛИППИНЫ
     * 
     */
    PH,

    /**
     * ФИНЛЯНДИЯ
     * 
     */
    FI,

    /**
     * ФОЛКЛЕНДСКИЕ ОСТРОВА (МАЛЬВИНСКИЕ)
     * 
     */
    FK,

    /**
     * ФРАНЦИЯ
     * 
     */
    FR,

    /**
     * ФРАНЦУЗСКАЯ ГВИАНА
     * 
     */
    GF,

    /**
     * ФРАНЦУЗСКАЯ ПОЛИНЕЗИЯ
     * 
     */
    PF,

    /**
     * ФРАНЦУЗСКИЕ ЮЖНЫЕ ТЕРРИТОРИИ
     * 
     */
    TF,

    /**
     * ХОРВАТИЯ
     * 
     */
    HR,

    /**
     * ЦЕНТРАЛЬНО-АФРИКАНСКАЯ РЕСПУБЛИКА
     * 
     */
    CF,

    /**
     * ЧАД
     * 
     */
    TD,

    /**
     * ЧЕРНОГОРИЯ
     * 
     */
    ME,

    /**
     * ЧЕШСКАЯ РЕСПУБЛИКА
     * 
     */
    CZ,

    /**
     * ЧИЛИ
     * 
     */
    CL,

    /**
     * ШВЕЙЦАРИЯ
     * 
     */
    CH,

    /**
     * ШВЕЦИЯ
     * 
     */
    SE,

    /**
     * ШПИЦБЕРГЕН И ЯН МАЙЕН
     * 
     */
    SJ,

    /**
     * ШРИ-ЛАНКА
     * 
     */
    LK,

    /**
     * ЭКВАДОР
     * 
     */
    EC,

    /**
     * ЭКВАТОРИАЛЬНАЯ ГВИНЕЯ
     * 
     */
    GQ,

    /**
     * ЭЛАНДСКИЕ ОСТРОВА
     * 
     */
    AX,

    /**
     * ЭЛЬ-САЛЬВАДОР
     * 
     */
    SV,

    /**
     * ЭРИТРЕЯ
     * 
     */
    ER,

    /**
     * ЭСТОНИЯ
     * 
     */
    EE,

    /**
     * ЭФИОПИЯ
     * 
     */
    ET,

    /**
     * ЮЖНАЯ АФРИКА
     * 
     */
    ZA,

    /**
     * ЮЖНАЯ ДЖОРДЖИЯ И ЮЖНЫЕ САНДВИЧЕВЫ ОСТРОВА
     * 
     */
    GS,

    /**
     * ЮЖНАЯ ОСЕТИЯ
     * 
     */
    OS,

    /**
     * ЮЖНЫЙ СУДАН
     * 
     */
    SS,

    /**
     * ЯМАЙКА
     * 
     */
    JM,

    /**
     * ЯПОНИЯ
     * 
     */
    JP;

    public String value() {
        return name();
    }

    public static CountriyCodeType fromValue(String v) {
        return valueOf(v);
    }

}
