class Solution:
    def palindrome (self, text: str) -> bool:
        n=len(text)
        L=["'",","," ","?","!"]
        for i in range(n):
            if text[i] in L:
                text.remove(i)
            else:
                continue
        text=text.lower()
        for i in range(0,1,n):
            for j in range(n,0,-1):
                if text[i]==text[j]:
                    continue
                else:
                    return False
        return True
            

            
            
  
