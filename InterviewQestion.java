
    public static int binarySearch(int[] arr, int target) {
    	int left = 0;
    	int right = arr.length - 1;
    	
    	while(left <= right) {
    		int mid = (left + right)/2;
    		if(arr[mid] == target) {
    			return mid;
    		}
    		else if(arr[mid] > target) {
    			right = mid - 1;
    		}
    		else if(arr[mid] < target) {
    			left = mid + 1;
    		}
    	}
    	return -1;
    }
    
    public static void combination(int[] arr, int target){
    	Set<int[]> sol = new HashSet();
    	Arrays.sort(arr);
    	int left = 0;
    	int right = arr.length - 1;
    	while(left <= right) {
    		if(arr[left] + arr[right] == target) {
    			sol.add(new int[] {arr[left], arr[right]});
    			left++;
    			right--;
    		}
    		else if(arr[left] + arr[right] > target) {
    			right--;
    		}
    		else if(arr[left] + arr[right] < target) {
    			left++;
    		}
    	}
    	int i = 1;
    	for(int[] st: sol) {
    		System.out.printf("%d.[%d,%d]%n",i++, st[0], st[1]);
    	}
    }
    
    public static int maxCoin(int[] arr) {
    	if(arr.length == 1) {
    		return arr[0];
    	}
    	else if(arr.length == 3) {
    		return arr[1]*arr[0]*arr[2]+maxCoin(new int[]{arr[0],arr[2]});
    	}
    	else if(arr.length == 2) {
    		return arr[0]*arr[1]+Math.max(arr[0], arr[1]);
    	}
    	else {
			int[] res = new int[arr.length];
    		for(int i = 0; i < arr.length; i++) {
    			int[] next = new int[arr.length-1];
    			for(int j = 0; j < arr.length-1; j++) {
    				if(j < i) next[j] = arr[j];
    				if(j >= i) next[j] = arr[j+1];
    			}
    			if(i == 0) {
    				res[i] = maxCoin(next) + arr[0]*arr[1];
    			}
    			else if(i == arr.length-1) {
    				res[i] = maxCoin(next) + arr[arr.length-1]*arr[arr.length-2];
    			}
    			else {
    				res[i] = maxCoin(next) + arr[i-1]*arr[i]*arr[i+1];
    			}
    		}
    		Arrays.sort(res);
    		return res[res.length-1];
    	}
    }
