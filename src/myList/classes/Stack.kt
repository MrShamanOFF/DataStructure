import myList.core.abstractClasses.AbstractLinkedList

/**
 * Односвязный класс. Стек
 * */
class Stack<T>: AbstractLinkedList<T>() {

    override fun addElementToFront(input: T) {
        addElementToEnd(input)
    }

}