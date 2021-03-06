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
package com.yydcdut.markdown.syntax.edit;

import androidx.annotation.NonNull;
import android.text.Editable;
import android.text.style.BackgroundColorSpan;

import com.yydcdut.markdown.MarkdownConfiguration;
import com.yydcdut.markdown.live.EditToken;
import com.yydcdut.markdown.syntax.SyntaxKey;
import com.yydcdut.markdown.utils.SyntaxUtils;

import java.util.List;

/**
 * The implementation of syntax for inline code.
 * syntax:
 * "`content`"
 * <p>
 * Created by yuyidong on 16/6/30.
 */
class CodeSyntax extends EditSyntaxAdapter implements SyntaxUtils.OnWhatSpanCallback {
    private static final String PATTERN = "(`)(.*?)(`)";

    private int mColor;

    public CodeSyntax(@NonNull MarkdownConfiguration markdownConfiguration) {
        super(markdownConfiguration);
        mColor = markdownConfiguration.getCodeBgColor();
    }

    @NonNull
    @Override
    public List<EditToken> format(@NonNull Editable editable) {
        return SyntaxUtils.parse(editable, PATTERN, SyntaxKey.KEY_CODE_BLOCK, this);
    }

    @Override
    public Object whatSpan() {
        return new BackgroundColorSpan(mColor);
    }
}
