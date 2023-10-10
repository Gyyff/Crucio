package com.heiqi.chat.common;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component

public class SensitiveWordsChecker {   //               src/main/resources/sensitive_words_lines.txt
    private final static String SENSITIVE_WORDS_FILE = "/root/sensitive_words_lines.txt"; // 敏感词库文件路径
    private List<String> sensitiveWords; // 敏感词列表
    private TrieNode root; // 字典树根节点

    public SensitiveWordsChecker() {
        sensitiveWords = new ArrayList<>();
        root = new TrieNode();
        try {
            sensitiveWords = FileUtils.readLines(new File(SENSITIVE_WORDS_FILE), Charset.defaultCharset());
            buildTrieTree();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建字典树
     */
    private void buildTrieTree() {
        for (String word : sensitiveWords) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containsChild(c)) {
                    node.addChild(c, new TrieNode());
                }
                node = node.getChild(c);
            }
            node.setEndOfWord(true);
        }
    }

    /**
     * 检查输入文本是否存在敏感词
     *
     * @param input 输入文本
     * @return 存在敏感词返回true，否则返回false
     */
    public boolean containsSensitiveWords(String input) {
        TrieNode node = root;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (node.containsChild(c)) {
                node = node.getChild(c);
                if (node.isEndOfWord()) {
                    return true;
                }
            } else {
                node = root;
            }
        }
        return false;
    }


    private static class TrieNode {
        private Map<Character, TrieNode> children; // 子节点
        private boolean endOfWord; // 是否为单词结尾

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }

        /**
         * 添加子节点
         */
        public void addChild(char c, TrieNode child) {
            children.put(c, child);
        }

        /**
         * 检查是否包含某个子节点
         */
        public boolean containsChild(char c) {
            return children.containsKey(c);
        }

        /**
         * 获取指定的子节点
         */
        public TrieNode getChild(char c) {
            return children.get(c);
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
    }
}
