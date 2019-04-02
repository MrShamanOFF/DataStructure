import myList.core.abstractClasses.AbstractLinkedList

/**
 * Односвязный класс
 * */
class List<T> : AbstractLinkedList<T>() {

    private var last: ListElement<T>? = null

    override fun addElementToFront(input: T) {
        val new = ListElement<T>()
        new.data = input

        when (anchor) {
            null -> {
                anchor = new
                last = new
                return
            }
        }
         new.linkToElement = anchor
         anchor = new
    }

    override fun addElementToEnd(input: T){
        val new = ListElement<T>()
        new.data = input

        when (last) {
            null -> {
                anchor = new
                last = new
                return
            }
        }
        last?.linkToElement = new
        last = new
    }

    override fun deleteElement() {
        when{
            last != null -> {
                deleteElement(last?.data!!)
                return
            }
        }
        println("Nothing to Delete")
    }

    override fun deleteElement(input: T) {
        when {
            anchor == null -> return
            anchor == last -> {
                anchor = null
                last = null
                return}
            anchor?.data == input -> {
                anchor = anchor?.linkToElement
                return
            }
        }
        var t: ListElement<T>? = anchor
        while (t?.linkToElement != null) {
            if (t.linkToElement?.data == input) {
                if (last == t.linkToElement)
                {
                    last = t
                }
                t.linkToElement = t.linkToElement?.linkToElement
                return
            }
            t = t.linkToElement
        }
    }

    override fun getNextElement(): T? {
        return last!!.data
    }

}