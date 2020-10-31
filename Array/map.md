if we need hashmap to reduce duplication and also need the origin order, then use:  
```
 for (int num : nums) {
      if (map.containsKey(num)) {
          if (map.get(num) == 1) {
              ans.add(num);
          }
      }
  }
```  
use the initial order to check the map value and add to the result.
