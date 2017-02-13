package com.epam.java.se;


/**
 * Created on 04.02.2017.
 */
public class IntBit {

    private long[] data = new long[0];

    //Конструкторы

    public IntBit (){}

    public IntBit (int value){
        add(value);
    }

    public IntBit (int[] newData){
        for (int aNewData : newData) {
            add(aNewData);
        }
    }

    private IntBit (long[] newData){
        data = newData;                     //конструктор приватный, забъем на безопасноть.
    }



    //Методы

    /**
     * Добавляет элемент в множество
     *
     * Добавляет элемент в множество. Автоматически расширяет массив, если размер меньше нужного.
     * Сначала находим индекс нужного элемента массива, потом место для добавляемого значения в элементе.
     * @param value добавляемый элемент
     */
    public void add(int value){
        int dataIndex;
        int element;
        dataIndex = value / 64;
        element = value % 64;

        if (value<0) {
            return;
        }

        if (dataIndex >= data.length) {
            resizeData(dataIndex);
        }

        data[dataIndex] = putElementToLong(data[dataIndex], element);
    }

    private long putElementToLong(long data, int element) {
        data |= 1L << element;
        return data;
    }


    private void resizeData(int newLength) {
        long[] newData = new long[newLength+1];
        System.arraycopy(data, 0, newData, 0,  data.length);
        data = newData;
    }

    /**
     *  Удаляет элемент из множества.
     *
     *  Удаляет элемент из множества. Сначала находим индекс нужного элемента массива,
     *  потом место удаляемого значения в элементе.
     * @param value удаляемый элемент.
     */
    public void remove(int value){
        int dataIndex;
        int element;
        dataIndex = value / 64;
        element = value % 64;

        if (value < 0||dataIndex>=data.length) {
            return;
        }

        data[dataIndex] = removeElementFromLong(data[dataIndex], element);
    }

    private long removeElementFromLong(long data, int element){
        data &= ~(1L<<element);
        return data;
    }

    /**
     * Возвращает true, если элемент есть во множестве, иначе false.
     *
     * Возвращает true, если элемент есть во множестве, иначе false. Сначала находим индекс нужного элемента
     * массива, потом место искомого значения в элементе.
     * @param value искомое значение.
     * @return true, если элемент есть во множестве, иначе false.
     */
    public boolean contains(int value){
        int dataIndex = value/64;
        int element = value%64;

        if (value < 0 || dataIndex >= data.length){
            return false;
        }

        final long res = data[dataIndex] & (1L<<element);
        return res!= 0;
    }

    /**
     * Возвращает множество, являющееся объединением множеств
     *
     * Возвращает множество, являющееся объединением множеств. Сначала идем по двум массивом с условием "или", после
     * окончания одного из них копируем без условий.
     *
     * @param other множество, с которым объединяем данное множество
     * @return множество, являюющееся объединеним множеств
     */
    public IntBit union (IntBit other){
        int dataUnionLength;
        long[] thisData = this.getData();
        long[] otherData = other.getData();
        dataUnionLength = Math.max(thisData.length, otherData.length);
        long[] dataUnion = new long[dataUnionLength];

        for (int i=0; i<dataUnionLength; i++){
            if (i<thisData.length && i<otherData.length){
                dataUnion[i]=thisData[i]|otherData[i];
            } else if (i<thisData.length && i >= otherData.length){  //лишнее условие вставил для единообразия
                dataUnion[i]=thisData[i];
            } else if (i<otherData.length && i>= thisData.length){   //лишнее условие вставил для единообразия
                dataUnion[i]=otherData[i];
            }
        }

        return new IntBit(dataUnion);
    }

    /**
     * Возвращает множество, являющееся пересечением множеств.
     *
     * Возвращает множество, являющееся пересечением множеств. Реализовано через: объединение минус пересечение.
     * @param other с чем пересекать
     * @return множество, являющееся пересечением множеств
     */

    public IntBit intersection(IntBit other){
        return (this.union(other)).minus(this.difference(other));
    }

    /**
     * Возвращает множество, являющееся симметрической разностью множеств.
     *
     * Возвращает множество, являющееся симметрической разностью множеств. Реализовано по определению через простейшие
     * операции.
     * @param other второе множество участвующее в операции
     * @return множество, являющееся симметрической разностью множеств this и other
     */

    public IntBit difference (IntBit other){
        return (this.minus(other)).union(other.minus(this));
    }

    /**
     * Возвращает true, если множество this является подмножеством other, иначе false.
     *
     * Возвращает true, если множество this является подмножеством other, иначе false. На самом деле отвечает на вопрос:
     * "Пуста ли разность множества this и множества other.
     * @param other второе множество участвующее в операции.
     * @return true, если множество this является подмножеством other, иначе false.
     */

    public boolean isSubsetOf(IntBit other){
        return this.minus(other).isEmpty();
    }

    private boolean isEmpty(){
        for (long aData : data) {
            if (aData != 0) return false;
        }
        return true;
    }

    private IntBit minus(IntBit other){
        long[] thisData = this.getData();
        long[] otherData = other.getData();
        long[] dataMinus = new long[thisData.length];

        for(int i = 0; i < thisData.length; i++){
            if (i < otherData.length) {
                dataMinus[i] = thisData[i] ^ (thisData[i] & otherData[i]);
            } else {
                dataMinus[i] = thisData[i];
            }
        }
        return new IntBit(dataMinus);
    }

    private long[] getData() {
        return data.clone();
    }
}
