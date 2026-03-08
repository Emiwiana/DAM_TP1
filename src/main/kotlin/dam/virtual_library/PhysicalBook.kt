package dam.virtual_library

class PhysicalBook(tittle: String, author: String, publicationYear: Int, availableCopies: Int,
    var weight : Int, var hasHardCover : Boolean = true) :
    Book(tittle, author, publicationYear, availableCopies) {

    override fun toString(): String {
        return super.toString() + "\n Storage: Physical Book: $weight g, Hardcover: $hasHardCover"
    }
}