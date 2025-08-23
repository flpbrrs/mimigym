package com.flpbrrs.mimigym.ui.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    val imn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imn.hideSoftInputFromWindow(windowToken, 0)
}