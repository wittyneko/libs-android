package cn.wittyneko.extensions

/**
 * Created by wittyneko on 17-6-26.
 */
// 三目运算符 1
inline fun <T> select(isTrue: Boolean, yes: T, no: T) = if (isTrue) yes else no

inline fun <T> select(isTrue: Boolean, yes: () -> T, no: () -> T) = if (isTrue) yes() else no()

// 三目运算符 2(isTrue % yes / no)
operator fun <T> Boolean.rem(yes: T) = Select(this, yes)

class Select<T>(val isTrue: Boolean, val yes: T) {
    inline operator fun div(no: T) = if (isTrue) yes else no
}

operator fun <T> Boolean.rem(yes: () -> T) = SelectFun(this, yes)

class SelectFun<T>(val isTrue: Boolean, val yes: () -> T) {
    operator fun div(no: () -> T) = if (isTrue) yes else no
}