package dam.virtual_library

class Library (val name: String) {
    private val bookList = ArrayList<Book>()
    fun addBook(book: Book){
        bookList.add(book)
    }

    fun borrowBook(tittle : String){
        for (book in bookList){
            if (book.tittle == tittle && book.availableCopies > 0) {
                println("Successfully borrowed '$tittle'. Copies remaining: ${book.availableCopies - 1}")
                book.availableCopies--
                return
            }
        }
        println("Failed to borrow '$tittle'. No copies in stock.")
    }

    fun returnBook(tittle: String){
        for (book in bookList){
            if (book.tittle == tittle) {
                book.availableCopies++
                println("Book '${book.tittle}' returned successfully. Copies available: ${book.availableCopies}")
            }
        }
    }

    fun showBooks(){
        for (book in bookList){
            println(book.toString())
        }
    }

    fun searchByAuthor(author : String){
        val filteredBooks = bookList.filter { it.author == author }
        if (filteredBooks.isEmpty()) println("No books from $author found.")
        else {
            for (book in filteredBooks) println(book.toString())
        }
    }
}