// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }


    "Median when size =1" {
        median(listOf(1f)) shouldBe (1f plusOrMinus tolerance)
        
    }

    "Median when size =2" {
        median(listOf(2f,6f)) shouldBe (4f plusOrMinus tolerance)

    }

    "Median when size = 3" {
        median(listOf(8f,3f,7f)) shouldBe (7f plusOrMinus tolerance)

    }

    "Median when size = 4" {
        median(listOf(4f,6f,2f,8f)) shouldBe (5f plusOrMinus tolerance)
    }


})
