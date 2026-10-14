// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact( text: String  , target: String , dub: Char = 'X') : String {
     

    val charstring =  dub.toString()
    val repeatString = charstring.repeat(target.length)
    val replaced = text.replace(target, repeatString)

    return replaced 
}

