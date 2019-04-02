package myList.core.interfaceClasses
/**
 * Двусвязный интерфейс
 * */

interface MyDoubleLinkedList<T>: MyLinkedList<T> {
    fun addElementToMiddle(positionFromFront: Int, input: T){}
    fun printAllElementsDesc()
}