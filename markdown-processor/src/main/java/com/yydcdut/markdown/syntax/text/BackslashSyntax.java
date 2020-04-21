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
package com.yydcdut.markdown.syntax.text;

import androidx.annotation.NonNull;
import android.text.SpannableStringBuilder;

import com.yydcdut.markdown.MarkdownConfiguration;
import com.yydcdut.markdown.syntax.SyntaxKey;

/**
 * The implementation of syntax for back slash.
 * syntax:
 * "\"
 * <p>
 * Created by yuyidong on 16/6/20.
 */
class BackslashSyntax extends TextSyntaxAdapter {

    public BackslashSyntax(@NonNull MarkdownConfiguration markdownConfiguration) {
        super(markdownConfiguration);
    }

    @Override
    boolean isMatch(@NonNull String text) {
        return text.contains(SyntaxKey.KEY_BACKSLASH);
    }

    @NonNull
    @Override
    boolean encode(@NonNull SpannableStringBuilder ssb) {
        return false;
    }

    @NonNull
    @Override
    SpannableStringBuilder format(@NonNull SpannableStringBuilder ssb, int lineNumber) {
        //----------  BoldSyntax && ItalicSyntax  ----------
        replace(ssb, SyntaxKey.KEY_BOLD_BACKSLASH_ASTERISK, SyntaxKey.KEY_BOLD_ASTERISK_SINGLE);
        replace(ssb, SyntaxKey.KEY_BOLD_BACKSLASH_UNDERLINE, SyntaxKey.KEY_BOLD_UNDERLINE_SINGLE);
        //----------  BoldSyntax && ItalicSyntax  ----------
        //----------  CenterAlignSyntax  ----------
        replace(ssb, SyntaxKey.KEY_CENTER_ALIGN_BACKSLASH_RIGHT, SyntaxKey.KEY_CENTER_ALIGN_RIGHT);
        //----------  CenterAlignSyntax  ----------
        //----------  FootnoteSyntax  ----------
        replace(ssb, SyntaxKey.KEY_FOOTNOTE_BACKSLASH_LEFT, SyntaxKey.KEY_FOOTNOTE_LEFT_SINGLE);
        replace(ssb, SyntaxKey.KEY_FOOTNOTE_BACKSLASH_CARET, SyntaxKey.KEY_FOOTNOTE_CARET);
        replace(ssb, SyntaxKey.KEY_FOOTNOTE_BACKSLASH_RIGHT, SyntaxKey.KEY_FOOTNOTE_RIGHT);
        //----------  FootnoteSyntax  ----------
        //----------  HyperLinkSyntax  ----------
//        replace(ssb, SyntaxKey.KEY_HYPER_LINK_BACKSLASH_LEFT, SyntaxKey.KEY_HYPER_LINK_LEFT);
//        replace(ssb, SyntaxKey.KEY_HYPER_LINK_BACKSLASH_MIDDLE, SyntaxKey.KEY_HYPER_LINK_MIDDLE_SINGLE);
        replace(ssb, SyntaxKey.KEY_HYPER_LINK_BACKSLASH_MIDDLE_RIGHT, SyntaxKey.KEY_HYPER_LINK_MIDDLE_RIGHT);
        replace(ssb, SyntaxKey.KEY_HYPER_LINK_BACKSLASH_RIGHT, SyntaxKey.KEY_HYPER_LINK_RIGHT);
        //----------  HyperLinkSyntax  ----------
        //----------  ImageSyntax  ----------
        replace(ssb, SyntaxKey.KEY_IMAGE_BACKSLASH_LEFT, SyntaxKey.KEY_IMAGE_LEFT_SINGLE);
//        replace(ssb, SyntaxKey.KEY_IMAGE_BACKSLASH_MIDDLE, SyntaxKey.KEY_IMAGE_MIDDLE_SINGLE);
//        replace(ssb, SyntaxKey.KEY_IMAGE_BACKSLASH_RIGHT, SyntaxKey.KEY_IMAGE_RIGHT);
        //----------  ImageSyntax  ----------
        //----------  CodeSyntax  ----------
        replace(ssb, SyntaxKey.KEY_CODE_BACKSLASH, SyntaxKey.KEY_CODE);
        //----------  CodeSyntax  ----------
        //----------  StrikeThroughSyntax  ----------
        replace(ssb, SyntaxKey.KEY_STRIKE_BACKSLASH, SyntaxKey.KEY_STRIKE_THROUGH_SINGLE);
        //----------  StrikeThroughSyntax  ----------
        //----------  other  ----------
        replace(ssb, SyntaxKey.KEY_DOT_BACKSLASH, SyntaxKey.KEY_DOT);
        replace(ssb, SyntaxKey.KEY_HYPHEN_BACKSLASH, SyntaxKey.KEY_HYPHEN);
        //----------  other  ----------
        return ssb;
    }

    @NonNull
    @Override
    void decode(@NonNull SpannableStringBuilder ssb) {
    }
}
