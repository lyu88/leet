class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] items = path.split(" ");
            for (int i = 1; i < items.length; i++) {
                String[] contents = items[i].split("\\(");
                map.computeIfAbsent(contents[1], k -> new ArrayList<>())
                    .add(String.join("/", items[0], contents[0]));
            }
        }
        return map.values().stream().filter(x -> x.size() > 1).toList();
    }
}