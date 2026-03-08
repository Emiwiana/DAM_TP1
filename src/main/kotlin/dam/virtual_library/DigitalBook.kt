package dam.virtual_library

class DigitalBook(tittle: String, author: String, publicationYear: Int, availableCopies: Int,
    var fileSize : Double, var format : String) :
    Book(tittle, author, publicationYear, availableCopies) {

        override fun toString(): String {
            return super.toString() + "\n Storage: Stored Digitally: $fileSize MB, Format: $format"
        }

}