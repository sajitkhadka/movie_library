import React from "react";
import ImageRow from "./browse/ImageRow";
import { Container, Row } from "reactstrap";

import Navbar from "../layout/navbar";
export default function browse() {
  return (
    <div>
      <Navbar />
      <Container className="themed-container">
        <Row className="pr-4 pl-4">
          <div>
            <h1>TV Shows</h1>
            <p>
              These days, the small screen has some very big things to offer.
              From sitcoms to dramas to travel and talk shows, these are all the
              best programs on TV.
            </p>
          </div>
        </Row>

        <ImageRow />
        <ImageRow />
        <ImageRow />
      </Container>
    </div>
  );
}
