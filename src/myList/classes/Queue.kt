import myList.core.abstractClasses.AbstractLinkedList

/**
 * Односвязный класс. Очередь
 * */
class Queue<T>: AbstractLinkedList<T>() {

    override fun addElementToEnd(input: T) {
        addElementToFront(input)
    }
    
}