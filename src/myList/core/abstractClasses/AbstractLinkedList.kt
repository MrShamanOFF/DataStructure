package myList.core.abstractClasses
import myList.core.interfaceClasses.MyLinkedList
/**
 * Двусвязный абстрактный класс
 * */

abstract class AbstractLinkedList<T>: MyLinkedList<T> {
    inner class ListElement<T> {
        var linkToElement: ListElement<T>? = null
        var data: T? = null
    }


    var anchor: ListElement<T>? = null

    override fun addElementToEnd(input: T) {
        val newElement = ListElement<T>()
        newElement.data = input
        if (anchor == null){
            anchor = newElement
        } else {
            var t = anchor
            while (t?.linkToElement != null){
                t = t.linkToElement
            }
            t?.linkToElement = newElement
        }
    }

    override fun addElementToFront(input: T) {
        val newElement = ListElement<T>()
        newElement.data = input
        when {
            anchor == null -> {
                anchor = newElement
                return
            }
        }
        val prev = anchor
        anchor = newElement
        anchor?.linkToElement = prev
    }

    override fun deleteElement() {
        when {
            anchor == null -> return
        }
        val prev = anchor?.linkToElement
        anchor = prev
    }

    override fun deleteElement(input: T) {
        deleteElement()
    }

    override fun getNextElement(): T? {
        return anchor!!.data
    }

    override fun printAllElements() {
        var p = anchor
        while (p != null){
            print("${p.data} \t")
            p = p.linkToElement
        }
        println()
    }
}