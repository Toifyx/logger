package com.toi.mobile.Tree;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

/**
 * @author fuyux
 */
public class MobileAnalysis {

    private final static String filePath = "D:\\Git\\demon\\logger\\src\\main\\java\\com\\toi\\mobile\\Tree\\mobile1.csv";

    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        try {
            File file = new File(filePath);

            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            CSVReader csvReader = new CSVReader(isr);

            String[] lines;
            do {
                lines = csvReader.readNext();
                if (lines != null) {
                    //System.out.println(lines[0] + "<>" + lines[1] + "<>" + lines[2]);

                    String line0 = lines[0].replace("\uFEFF", "");
                    String line1 = lines[1].replace("\uFEFF", "");
                    String line2 = lines[2].replace("\uFEFF", "");

                    //System.out.println("line[0]"+ StringUtils.abbreviate(line0))

                    // par line1
                    TreeNode nextRoot = root;
                    for (int i = 0; i < line0.length(); i++) {
                        char point = line0.charAt(i);

                        // root tree find children
                        List<TreeNode> children = nextRoot.getChildren();
                        boolean hasChildren = false;
                        TreeNode childrenNode = null;
                        for (TreeNode node : children) {
                            if (node.getId() == point) {
                                //System.out.println(node.getId() + "==" + point);
                                hasChildren = true;
                                nextRoot = node;
                            }
                        }

                        //find or create
                        if (!hasChildren) {
                            TreeNode newTree = new TreeNode();
                            newTree.setId(point);
                            nextRoot = newTree;

                            // add newTree to father
                            children.add(newTree);
                        }
                    }

                    // par line 3
                    String[] range = StringUtils.split(line2, "-");
                    if (range.length == 1) {
                        for (int i = 0; i < line2.length(); i++) {
                            char point = line2.charAt(i);
                            List<TreeNode> children = nextRoot.getChildren();

                            TreeNode newTree = new TreeNode();
                            newTree.setId(point);
                            nextRoot = newTree;

                            // add newTree to father
                            children.add(newTree);
                        }
                    } else {
                        String range1 = range[0];
                        String range2 = range[1];
                        for (int i = 0; i < range1.length(); i++) {
                            char start = range1.charAt(i);
                            char end = range2.charAt(i);

                            List<TreeNode> children = nextRoot.getChildren();

                            TreeNode newTree = new TreeNode();
                            newTree.setStart(start);
                            newTree.setEnd(end);
                            newTree.setName(line1);
                            nextRoot = newTree;

                            // add newTree to father
                            children.add(newTree);
                        }
                    }
                }

            } while (lines != null);

            //find mbile no by tree
            String mobile = "13807871500";
            findMobileCity(root, mobile);
            findMobileCity(root, "13975260095");
            findMobileCity(root, "13557514123");
            findMobileCity(root, "13557514123");
            findMobileCity(root, "15978253499");
            findMobileCity(root, "15978253500");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void findMobileCity(TreeNode root, String mobile) {
        List<TreeNode> childrens = root.getChildren();
        TreeNode nextNode;
        for (int i = 0; i < mobile.length(); i++) {
            char poin = mobile.charAt(i);
            for (TreeNode node : childrens) {
                if (node.getId() == poin
                        || (poin >= node.getStart() && poin <= node.getEnd())) {
                    if (node.getChildren().size() != 0) {
                        // have next children continue
                        nextNode = node;
                        childrens = nextNode.getChildren();
                        break;
                    } else {
                        //find
                        System.out.println("mobile: " + mobile + ",city :" + node.getName());
                    }

                }
            }
        }
    }
}

