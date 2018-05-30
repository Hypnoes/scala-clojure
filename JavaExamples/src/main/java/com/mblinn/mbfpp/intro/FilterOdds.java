public List<Integer> filterOdds(List<Integer> list) {
    List<Integer> filteredList = new ArrayList<Integer>();
    for (Integer current : list) {
        if (isOdd(current)) {
            filteredList.add(current);
        }
    }
    return filteredList;
}

private boolean isOdd(Integer integer) {
    return 0 != integer % 2;
}

