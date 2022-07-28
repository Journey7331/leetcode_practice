package cn.hua.year2022._7Jul.day27;

// 592. 分数加减运算
// 中等题
class FractionAddition {
    public String fractionAddition(String expression) {
char before='+';
        if (expression.charAt(0)=='-'){
            expression=expression.substring(1);
            before='-';
        }
        String[] nums=expression.split("[+-]");
        String[] n=nums[0].split("/");
        int[] temp=new int[]{Integer.parseInt(n[0]),Integer.parseInt(n[1])};
        simplify(temp);
        int j=1;
        for (int i=0;i<expression.length() && j<nums.length;i++){
            if (expression.charAt(i)=='+' || expression.charAt(i)=='-'){
                before=add(temp,nums[j++],expression.charAt(i),before);
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(before=='-'?before:"");
        sb.append(temp[0]);
        sb.append("/");
        sb.append(temp[1]);
        return sb.toString();
    }

    public char add(int[] f1,String f2,char c,char before){
        String[] f2num=f2.split("/");
        int m2=Integer.parseInt(f2num[1]);
        int z2=Integer.parseInt(f2num[0]);
        if (f1[0]==0){
            f1[0]=z2;
            f1[1]=m2;
            return c;
        }
        int bei=bei(f1[1],m2);
        if (before=='+'){
            f1[0]=(c=='+'?f1[0]*(bei/f1[1])+z2*(bei/m2):f1[0]*(bei/f1[1])-z2*(bei/m2));
            if (f1[0]<0){
                f1[0]=0-f1[0];
                before='-';
            }
        }else{
            if (c=='-'){
                f1[0]=f1[0]*(bei/f1[1])+z2*(bei/m2);
            }else {
                f1[0]=z2*(bei/m2)-f1[0]*(bei/f1[1]);
                if (f1[0]>=0){
                  before='+';
                }else {
                    f1[0]=0-f1[0];
                }
            }
        }
        f1[1]=bei;
        simplify(f1);
        return before;
    }

    public void simplify(int[] nums){
        if (nums[0]==0) {
            nums[1]=1;
            return;
        }
        int yue=yue(nums[0],nums[1]);
        nums[0]/=yue;
        nums[1]/=yue;
    }

    public int bei(int num1,int num2){
        return num1*num2/yue(num1,num2);
    }

    public int yue(int num1,int num2){
        int min=Math.min(num1,num2);
        int max=Math.max(num1,num2);
        while (max%min!=0){
            int yu=max%min;
            max=min;
            min=yu;
        }
        return min;
    }
}
