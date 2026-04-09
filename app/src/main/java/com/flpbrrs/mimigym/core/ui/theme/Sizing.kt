package com.flpbrrs.mimigym.core.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    /** Usage: gap between lines in texts */
    val xxs: Dp = 2.dp,
    /** Usage: minimal gap between elements */
    val xs: Dp = 4.dp,
    /** Usage: internal gap for composed items */
    val sm: Dp = 6.dp,
    /** Usage: padding inline, gap between inline elements */
    val md: Dp = 8.dp,
    /** Usage: gap for cards in lists */
    val default: Dp = 10.dp,
    /** Usage: gap bullet -> text, vertical padding for list items*/
    val lg: Dp = 12.dp,
    /** Usage: gap avatar -> text, icon gap*/
    val xl: Dp = 14.dp,
    /** Usage: internal gap for card and buttons*/
    val cardPadding: Dp = 16.dp,
    /** Usage: horizontal margin for pages - inner content*/
    val pagePadding: Dp = 20.dp,
    /** Usage: top bar padding, space between sections*/
    val sectionGap: Dp = 24.dp,
    /** Usage: large space between sections */
    val sectionGapLg: Dp = 28.dp,
    /** Usage: padding top for top bar*/
    val statusBar: Dp = 48.dp,
)

data class Radius(
    /** Usage: badges*/
    val sm: Dp = 8.dp,
    /** Usage: icon container*/
    val md: Dp = 12.dp,
    /** Usage: buttons */
    val lg: Dp = 14.dp,
    /** Usage: containers*/
    val xl: Dp = 16.dp,
    /** Usage: avatar, circles*/
    val full: Dp = 1000.dp,
)

data class Sizes(
    /** Usage: user avatar*/
    val avatar: Dp = 48.dp,
    /** Usage: component */
    val container: Dp = 40.dp,
    /** Usage: bullets*/
    val bullet: Dp = 6.dp,
)

val localSpacing = compositionLocalOf { Spacing() }
val localRadius = compositionLocalOf { Radius() }
val localSizes = compositionLocalOf { Sizes() }