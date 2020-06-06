package cn.chuxiao.designpattern.strategy.case1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现对一个文件进行排序的功能。文件中只包含整型数，并且相邻的数字通过逗号来区隔
 * <p>
 * 将文件中的内容读取出来，并且通过逗号分割成一个一个的数字，放到内存数组中，然后编写某种排序算法（比如快排），
 * 或者直接使用编程语言提供的排序函数，对数组进行排序，最后再将数组中的数据写入文件就可以了。
 * <p>
 * 如果文件很大,比如有10GB大小，因为内存有限（比如只有8GB大小），没办法一次性加载文件中的所有数据到内存中，
 * 这个时候，就要利用外部排序算法（可以参看《数据结构与算法之美》中的“排序”相关章节）
 * <p>
 * 如果文件更大，比如有100GB大小，为了利用CPU多核的优势，可以在外部排序的基础之上进行优化，加入多线程并发排序的功能，
 * 这就有点类似“单机版”的MapReduce。
 * <p>
 * 如果文件非常大，比如有1TB大小，即便是单机多线程排序，这也算很慢了。这个时候，可以使用真正的MapReduce框架，
 * 利用多机的处理能力，提高排序的效率
 */
public class SorterNew3 {

    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
    }

    private void sortFile(String filePath) {
        //省略校验逻辑

        File file = new File(filePath);
        long fileSize = file.length();

        ISortAlg sortAlg = null;
        for (AlgRange algRange : algs) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getAlg();
                break;
            }
        }
        sortAlg.sort(filePath);

    }

    private static class AlgRange {
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start, long end, ISortAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public ISortAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
