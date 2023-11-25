final class ListComparator {
    private ListComparator() { }

    /**
     * Methods comparing integer arrays
     * and showing comparison results to stdout.
     * @param first first array
     * @param second second array
     */
    public static void compareLists(final IntArray first,
                                    final IntArray second) {
        int result = compareListsInternal(first, second);
        switch (result) {
            case 1 ->
                    System.out.println(
                            "Первый список имеет большее среднее значение"
                    );
            case 2 ->
                    System.out.println(
                            "Второй список имеет большее среднее значение"
                    );
            default ->
                    System.out.println(
                            "Средние значения равны"
                    );
        }
    }

    private static int compareListsInternal(final IntArray first,
                                            final IntArray second) {
        if (first.getAverage() > second.getAverage()) {
            return 1;
        }
        if (second.getAverage() > first.getAverage()) {
            return 2;
        }
        return 0;
    }
}
