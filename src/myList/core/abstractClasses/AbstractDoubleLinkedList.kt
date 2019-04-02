package myList.core.abstractClasses
import myList.core.interfaceClasses.MyDoubleLinkedList
/**
 * Односвязный абстрактный класс
 * */

abstract class AbstractDoubleLinkedList<T>: MyDoubleLinkedList<T>{
    inner class DoubleLinkedListElement<T>{
        var linkToNextElement: DoubleLinkedListElement<T>? = null
        var linkToPrevElement: DoubleLinkedListElement<T>? = null
        var data: T? = null
    }

    private var first: DoubleLinkedListElement<T>? = null
    private var last: DoubleLinkedListElement<T>? = null

    override fun addElementToFront(input: T){
        val newElement = DoubleLinkedListElement<T>()
        newElement.data = input

        when{
            first == null -> {
                first = newElement
                last = newElement
                return
            }
            first == last ->{
                first = newElement
                first?.linkToNextElement = last
                last?.linkToPrevElement = first
                return
            }
        }
        val midle = first
        first = newElement
        midle?.linkToPrevElement = first
        first?.linkToNextElement = midle
    }

    override fun addElementToEnd(input: T){
        val newElement = DoubleLinkedListElement<T>()
        newElement.data = input

        when{
            first == null -> {
                first = newElement
                last = newElement
                return
            }
            first == last ->{
                last = newElement
                last?.linkToPrevElement = first
                first?.linkToNextElement = last
                return
            }
        }
        val midle = last
        last = newElement
        midle?.linkToNextElement = last
        last?.linkToPrevElement = midle
    }

    override fun addElementToMiddle(positionFromFront: Int, input: T) {
        val newElement = DoubleLinkedListElement<T>()
        newElement.data = input

        when{
            first == null -> {
                first = newElement
                last = newElement
                return
            }
            first == last -> {
                first = newElement
                first?.linkToNextElement = last
                last?.linkToPrevElement = first
                return
            }
        }
        var midle = first
        var i = 1
        while (i < positionFromFront){
            if (midle?.linkToNextElement != null){
                midle = midle.linkToNextElement!!
            } else {
                println("Out of range")
                return
            }
            i++
        }
        newElement.linkToPrevElement = midle?.linkToPrevElement
        midle?.linkToPrevElement?.linkToNextElement = newElement
        newElement.linkToNextElement = midle
    }

    override fun printAllElements(){
        var p = first
        while (p != null){
            print("${p.data} \t")
            p = p.linkToNextElement
        }
        println()
    }

    override fun printAllElementsDesc(){
        var p = last
        while (p != null){
            print("${p.data} \t")
            p = p.linkToPrevElement
        }
        println()
    }

    override fun deleteElement(input: T){
        when {
            first == null -> return
            first == last -> {
                first = null
                last = null
                return}
            first?.data == input -> {
                first = first?.linkToNextElement
                first?.linkToPrevElement = null
                return
            }
            last?.data == input -> {
                last = last?.linkToPrevElement
                last?.linkToNextElement = null
                return
            }
        }
        var f = first
        var l = last
        while (f != l) {
            if (f?.data == input){
                f?.linkToPrevElement?.linkToNextElement = f?.linkToNextElement
                f?.linkToNextElement?.linkToPrevElement = f?.linkToPrevElement
                return
            }
            if (l?.data == input){
                l?.linkToNextElement?.linkToPrevElement = l?.linkToPrevElement
                l?.linkToPrevElement?.linkToNextElement = l?.linkToNextElement
                return
            }
            f = f?.linkToNextElement
            l = l?.linkToPrevElement
        }

    }

    override fun deleteElement() {
        println("Operation does not support")
    }

    override fun getNextElement(): T? {
        return null
    }
}