package com.interview.codegame.LeetCode;

/**
 * @author Yulin.Wang
 * @date 2021/6/18
 * @description
 *
 * 给你一个以字符串形式表述的布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 * 输入：expression = "!(f)"
 * 输出：true
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 */

public class P1106_BoolParser {
}
