import React from "react";
import error404Image from "../img/error404.svg";
import styled from "styled-components/macro";

import Navbar from "../layout/navbar";

var Image = styled.div`
  width: auto;
  background-color: lightcoral;
  background: url(${error404Image}) no-repeat center;
  flex: 2;
  @media screen and (max-width: 768px) {
    display: none;
  }
`;

const error404 = () => {
  return (
    <React.Fragment>
      <Navbar />
      <h2 style={{ marginTop: "5%", textAlign: "center" }}>
        Sorry, this page does not exist!
      </h2>
      <div className="md-12 container">
        <Image className="ui img-responsive" />
      </div>
    </React.Fragment>
  );
};
export default error404;
