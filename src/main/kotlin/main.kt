val time = 24*60*60
fun main(){
    val timeSeconds = agoToText(time)
    println(timeSeconds)
}
fun agoToText(time: Int): String {
    var ending = when {
        0 <= time && time < 60 -> "только что"
        60 <= time && time <= (60*60) -> agoToMinutes(time)
        (60*60+1) <= time && time <= (24 * 60 * 60) -> agoToHour(time)
        (24 * 60 * 60) < time && time <= (24 * 60 * 60*2) -> "сегодня"
        (24 * 60 * 60*2) < time && time <= (24 * 60 * 60*3) -> "вчера"
        else -> "давно"
    }
    return ending
}
fun agoToMinutes(time: Int): String {
    var text1 = when {
        61 <= time && time < (60*2) -> (time/60).toInt().toString() + " минуту назад"
        2 <= (time/60).toInt()%10 && (time/60).toInt()%10 <= 4  -> (time/60).toInt().toString() + " минуты назад"
        (60*11) < time && (time/60 ).toInt()%10 == 1 -> (time/60).toInt().toString() + " минуту назад"
        else -> (time/60).toInt().toString() + " минут назад"
    }
    return text1
}
fun agoToHour(time: Int): String {
    var text2 = when {
        (time/60/60).toInt()%10 == 1 -> (time/60/60).toInt().toString() + " час назад"
        2 <= (time/60/60).toInt()%10 && (time/60/60).toInt()%10 <= 4 -> (time/60/60).toInt().toString() + " часа назад"
        else -> (time/60/60).toInt().toString() + " часов назад"
    }
    return text2
}