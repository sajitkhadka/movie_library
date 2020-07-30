import styled, { keyframes } from "styled-components";
import React from "react";

const spin = keyframes`
0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
`;

const Outer = styled.div`
  width: 100%;
  margin: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Loader = styled.div`
  position: relative;
  margin-top: 20px;
  margin-left: 20px;
  border: 0.1rem solid #f3f3f3;
  border-top: 0.5rem solid #3498db;
  border-radius: 50%;
  width: 3rem;
  height: 3rem;
  animation: ${spin} 0.5s linear infinite;
`;

export default function SpinnerComponent() {
  return (
    <Outer>
      <Loader />
    </Outer>
  );
}
