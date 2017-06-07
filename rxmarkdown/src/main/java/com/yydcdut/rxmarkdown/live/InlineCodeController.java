/*
 * Copyright (C) 2016 yydcdut (yuyidong2015@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.yydcdut.rxmarkdown.live;

import android.text.Editable;
import android.text.style.BackgroundColorSpan;

import com.yydcdut.rxmarkdown.syntax.edit.EditFactory;
import com.yydcdut.rxmarkdown.utils.Utils;

import java.util.List;

/**
 * RxMDEditText, inline code controller.
 * <p>
 * Created by yuyidong on 16/7/22.
 */
public class InlineCodeController extends AbsEditController {

    private static final String KEY = "`";

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int after) {
        super.beforeTextChanged(s, start, before, after);
        if (before == 0 || mRxMDConfiguration == null) {
            return;
        }
        String deleteString = s.subSequence(start, start + before).toString();
        if (deleteString.contains(KEY)) {
            shouldFormat = true;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int after) {
        if (mRxMDConfiguration == null || !(s instanceof Editable)) {
            return;
        }
        if (shouldFormat) {
            format((Editable) s, start);
            return;
        }
        if (after == 0) {
            return;
        }
        String addString;
        addString = s.subSequence(start, start + after).toString();
        if (addString.contains(KEY)) {
            format((Editable) s, start);
        }
    }

    private void format(Editable editable, int start) {
        Utils.removeSpans(editable, start, BackgroundColorSpan.class);
        if (mGrammar == null) {
            mGrammar = EditFactory.create().getInlineCodeGrammar(mRxMDConfiguration);
        }
        List<EditToken> editTokenList = Utils.getMatchedEditTokenList(editable, mGrammar.format(editable), start);
        Utils.setSpans(editable, editTokenList);
    }
}