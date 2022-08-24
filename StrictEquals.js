/*
From: JustJavascript course

Problem:
Write a function called strictEquals(a, b) that returns the same value as a === b.
Your implementation must not use the === or !== operators.
*/

function strictEquals(a, b) {
    // first special case of strict equality (NaN===NaN) -> false
    if (Object.is(a, NaN) && Object.is(b, NaN)) {
      return false;
    } else if (
      (Object.is(a, 0) || Object.is(a, -0)) &&
      (Object.is(b, 0) || Object.is(b, -0))
    ) {
      // second special case of strict equality (-0===0) -> true
      return true;
    } else {
      return Object.is(a, b);
    }
  }
  
  // results
  // strictEquals(NaN, NaN) -> false
  // strictEquals(-0, 0) -> true
  // strictEquals("2", "2") -> true
  // strictEquals(3, 3) -> true
