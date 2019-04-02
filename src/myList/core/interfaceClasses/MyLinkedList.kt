package myList.core.interfaceClasses
/**
* Односвязный интерфейс
* */

interface MyLinkedList<T> {
    fun addElementToFront(input: T)
    fun addElementToEnd(input: T)
    fun printAllElements()
    fun deleteElement(input: T)
    fun deleteElement()
    fun getNextElement(): T?
}