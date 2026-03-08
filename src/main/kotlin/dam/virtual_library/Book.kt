package dam.virtual_library

open class Book (var tittle: String, val author : String, PublicationYear : Int, availableCopies : Int){
    private var PublicationYear = PublicationYear
    val publicationYear: String
        get() {
            return if (PublicationYear < 1980) "Classic"
            else if (PublicationYear < 2010) "Modern"
            else "Contemporary"
        }

    var availableCopies : Int = availableCopies
        set(nCopies) {
            if (nCopies < 0) field = availableCopies
            else field = nCopies
            if (nCopies == 0) println("Warning: Book is now out of stock!")
        }

    override fun toString(): String {
        return "Tittle: $tittle, Author $author, Era: $publicationYear, Available: $availableCopies copies"
    }
}