class Solution {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        String[] addresses = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String address : addresses) {
            if (address.equals(".") || address.isEmpty()) {
                continue;
            } else if (address.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(address);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
