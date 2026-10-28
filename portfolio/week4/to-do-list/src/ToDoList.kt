// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted get() = items.count{it.status == ItemStatus.NotStarted}  // compute no. of items with NotStarted status
    val inProgress get() = items.count{it.status == ItemStatus.InProgress}  // compute no. of items with InProgress status
    val done get() = items.count{it.status == ItemStatus.Done}      // compute no. of items with Done status
    val overdue get() = items.count{it.isOverdue() }    // compute no. of overdue items

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {

        Path(filename).forEachLine { line ->
            
        val parts = line.split(":").map { it.trim() }
        
        val clrdate = LocalDate.parse(parts[0])
        val clrstatus = ItemStatus.valueOf(parts[1])
        val clrdesc = parts[2]

        items.add(ToDoItem(clrdate,clrstatus,clrdesc))

        }
        // Implement code to read To Do list from a file here
        // See data/to-do.csv for an example of the format
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {

        return items.removeAll {

            it.status == ItemStatus.Done
        }
        // Write code here to remove items with status of Done
        // Return true if any were removed, false if none were removed
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {

        return items.filter {
            status == null || it.status == status
        }
        // Write code here to return a list of items with the matching
        // status, or a list of all items if status argument is null
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {

        return items.filter {
            it.dueDate == date
        }
        // Write code here to return a list of items
        // that are due on the specified date
    }
}
