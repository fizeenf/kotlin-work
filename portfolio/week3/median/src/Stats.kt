// Task 7.7.1: statistics functions

fun median( values: List<Float> ): Float {
    require(values.isNotEmpty()) 
    // requires list to be non empty 
    // if empty, require() throws an IllegalArgumentException

    val sortedValues = values.sorted()
    //sorts values in asc order

     if (sortedValues.size % 2 != 0) {
        //one middle val returned for odd sized list
        //diving by 2 gives the middle index
        return sortedValues[sortedValues.size / 2]
     }
     
     else {
        //2 middle values in each even sized list
        //first middle val found using (size/2-1)
        //second middle val found using (size/2)
        // add the two values and divide by 2 to calculate avg
        return(sortedValues[sortedValues.size/ 2 - 1] + 
            sortedValues[sortedValues.size / 2]) / 2f

        }
    }

    // sortedValues.size - counts no. of items
    // sortedValues.size / 2 - finds second middle val in even lists
    // sortedValues.size / 2-1 - finds the first middle index
    // sortedValues[] - gets value at index