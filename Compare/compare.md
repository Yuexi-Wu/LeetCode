compare p1, p2:  
if p1 < p2: p1.compareTo(p2) returns -1;  
if p1 = p2: p1.compareTo(p2) returns 0;  
if p1 > p2: p1.compareTo(p2) returns 1;  
  
Arrays.sort(array, (p1, p2) -> (p1 - p2)); -- sort from small to large. 
  
Arrays.sort(array, (p1, p2) -> {...});  
if ... returns -1, keep origin position, if returns 1, swap p1 with p2.
