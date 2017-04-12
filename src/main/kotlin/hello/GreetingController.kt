package hello

import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class GreetingController
{
    private val template : String =  "Hello, %s!"
    private val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting")
    internal fun greeting(@RequestParam(value = "name", defaultValue = "World") name : String) : Greeting
    {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }
}
