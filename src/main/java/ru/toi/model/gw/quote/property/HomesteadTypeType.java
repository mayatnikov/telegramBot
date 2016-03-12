
package ru.toi.model.gw.quote.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HomesteadType_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HomesteadType_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="consumer_electronics"/>
 *     &lt;enumeration value="ammunition"/>
 *     &lt;enumeration value="water_pumps"/>
 *     &lt;enumeration value="lawn"/>
 *     &lt;enumeration value="precious_metals_bullion"/>
 *     &lt;enumeration value="other_movable"/>
 *     &lt;enumeration value="animals"/>
 *     &lt;enumeration value="spare_parts"/>
 *     &lt;enumeration value="articles_precious"/>
 *     &lt;enumeration value="measuring"/>
 *     &lt;enumeration value="information"/>
 *     &lt;enumeration value="collections_art"/>
 *     &lt;enumeration value="houseplants"/>
 *     &lt;enumeration value="furniture"/>
 *     &lt;enumeration value="motor_vehicles"/>
 *     &lt;enumeration value="musical_instruments"/>
 *     &lt;enumeration value="cash"/>
 *     &lt;enumeration value="overal_limit"/>
 *     &lt;enumeration value="firearms"/>
 *     &lt;enumeration value="clothes"/>
 *     &lt;enumeration value="household"/>
 *     &lt;enumeration value="food"/>
 *     &lt;enumeration value="manuscripts"/>
 *     &lt;enumeration value="sports_equipment"/>
 *     &lt;enumeration value="carpenter"/>
 *     &lt;enumeration value="construction"/>
 *     &lt;enumeration value="fertilizers"/>
 *     &lt;enumeration value="physical_memory"/>
 *     &lt;enumeration value="photo_equipment"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HomesteadType_Type", namespace = "http://toi.ru/model/gw/quote/property")
@XmlEnum
public enum HomesteadTypeType {


    /**
     * Аудио-, видеоаппаратура, электроника, бытовая техника
     * 
     */
    @XmlEnumValue("consumer_electronics")
    CONSUMER_ELECTRONICS("consumer_electronics"),

    /**
     * Боеприпасы, взрывчатые и легковоспламеняющиеся вещества, пиротехнические изделия
     * 
     */
    @XmlEnumValue("ammunition")
    AMMUNITION("ammunition"),

    /**
     * Водяные насосы и прочие механизмы
     * 
     */
    @XmlEnumValue("water_pumps")
    WATER_PUMPS("water_pumps"),

    /**
     * Газонокосилки, мотоблоки
     * 
     */
    @XmlEnumValue("lawn")
    LAWN("lawn"),

    /**
     * Драгоценные и полудрагоценные металлы в слитках, драгоценные и полудрагоценные камни без оправ
     * 
     */
    @XmlEnumValue("precious_metals_bullion")
    PRECIOUS_METALS_BULLION("precious_metals_bullion"),

    /**
     * Другое движимое имущество, указанное в договоре страхования
     * 
     */
    @XmlEnumValue("other_movable")
    OTHER_MOVABLE("other_movable"),

    /**
     * Животные
     * 
     */
    @XmlEnumValue("animals")
    ANIMALS("animals"),

    /**
     * Запасные части, детали и принадлежности к транспортным средствам
     * 
     */
    @XmlEnumValue("spare_parts")
    SPARE_PARTS("spare_parts"),

    /**
     * Изделия из драгоценных металлов и/или драгоценных камней
     * 
     */
    @XmlEnumValue("articles_precious")
    ARTICLES_PRECIOUS("articles_precious"),

    /**
     * Измерительные и оптические приборы
     * 
     */
    @XmlEnumValue("measuring")
    MEASURING("measuring"),

    /**
     * Информация на носителях любых видов, литографии, пленки, клише
     * 
     */
    @XmlEnumValue("information")
    INFORMATION("information"),

    /**
     * Коллекции или произведения искусства
     * 
     */
    @XmlEnumValue("collections_art")
    COLLECTIONS_ART("collections_art"),

    /**
     * Комнатные растения
     * 
     */
    @XmlEnumValue("houseplants")
    HOUSEPLANTS("houseplants"),

    /**
     * Мебель (кроме встроенной)
     * 
     */
    @XmlEnumValue("furniture")
    FURNITURE("furniture"),

    /**
     * Моторные транспортные средства
     * 
     */
    @XmlEnumValue("motor_vehicles")
    MOTOR_VEHICLES("motor_vehicles"),

    /**
     * Музыкальные инструменты
     * 
     */
    @XmlEnumValue("musical_instruments")
    MUSICAL_INSTRUMENTS("musical_instruments"),

    /**
     * Наличные деньги, банковские карты, ценные бумаги
     * 
     */
    @XmlEnumValue("cash")
    CASH("cash"),

    /**
     * Общий лимит с возможностью выставлять поэлементные лимиты
     * 
     */
    @XmlEnumValue("overal_limit")
    OVERAL_LIMIT("overal_limit"),

    /**
     * Огнестрельное оружие
     * 
     */
    @XmlEnumValue("firearms")
    FIREARMS("firearms"),

    /**
     * Одежда, посуда, игрушки
     * 
     */
    @XmlEnumValue("clothes")
    CLOTHES("clothes"),

    /**
     * Предметы домашней обстановки, интерьера
     * 
     */
    @XmlEnumValue("household")
    HOUSEHOLD("household"),

    /**
     * Продукты питания, спиртные напитки и табачные изделия, парфюмерно-косметические изделия, а также лекарства
     * 
     */
    @XmlEnumValue("food")
    FOOD("food"),

    /**
     * Рукописи, планы, чертежи, бухгалтерские и деловые книги, иные документы
     * 
     */
    @XmlEnumValue("manuscripts")
    MANUSCRIPTS("manuscripts"),

    /**
     * Спортивный и охотничий инвентарь
     * 
     */
    @XmlEnumValue("sports_equipment")
    SPORTS_EQUIPMENT("sports_equipment"),

    /**
     * Столярный, плотницкий, слесарный и иной хоз. инвентарь, инструменты Electric tools/Электрические инструменты
     * 
     */
    @XmlEnumValue("carpenter")
    CARPENTER("carpenter"),

    /**
     * Строительные и отделочные материалы, предназначенные для строительства и/или ремонта квартиры, строения
     * 
     */
    @XmlEnumValue("construction")
    CONSTRUCTION("construction"),

    /**
     * Удобрения, ядохимикаты и воспламеняющиеся жидкости
     * 
     */
    @XmlEnumValue("fertilizers")
    FERTILIZERS("fertilizers"),

    /**
     * Физические носители информации
     * 
     */
    @XmlEnumValue("physical_memory")
    PHYSICAL_MEMORY("physical_memory"),

    /**
     * Фотоаппаратура
     * 
     */
    @XmlEnumValue("photo_equipment")
    PHOTO_EQUIPMENT("photo_equipment");
    private final String value;

    HomesteadTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HomesteadTypeType fromValue(String v) {
        for (HomesteadTypeType c: HomesteadTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
