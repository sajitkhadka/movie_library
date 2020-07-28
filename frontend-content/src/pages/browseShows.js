import React from "react";
import ImageRow from "./browse/ImageRow";
import { Container, Row } from "reactstrap";

import {
  Metadata,
  MetadataItem,
  Title,
  Synopsis,
  Creators,
} from "./styled-components/components";

import Navbar from "../layout/navbar";
export default function browse() {
  return (
    <div>
      <Navbar />
      <Container className="themed-container">
        <Row className="pr-4 pl-4">
          <div style={{ maxWidth: "500px", marginBottom: "20px" }}>
            <Title>TV Shows</Title>
            <Synopsis>
              These days, the small screen has some very big things to offer.
              From sitcoms to dramas to travel and talk shows, these are all the
              best programs on TV.
            </Synopsis>
          </div>
        </Row>

        <ImageRow />
        <ImageRow />
        <ImageRow />
      </Container>
    </div>
  );
}
