function solution(i,j){
  let longest = 0;
  for(let k = i; k <= j; ++k){
      //console.log('k',k);
      seq = genSeq(k);
      //console.log('seq',seq);
      if (seq.length > longest ){
        longest = seq.length
      }
  }
  console.log(i , j, longest);
}
function genSeq(n){
  let seq = [n]
	while(n !== 1){
    if( n % 2 === 0){
      n /= 2;
    }else{
      n = 3*n+1
    }
    seq.push(n)
	}
  return seq
}

solution(1,10)
solution(100,200)
solution(201,210)
solution(900,1000)

