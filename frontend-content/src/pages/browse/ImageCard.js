import React from "react";
import { Card, CardTitle } from "reactstrap";
import { Link } from "react-router-dom";
import defaultImage from "../../img/default.jpg";
export default function ImageCard(props) {
  const value = props.movie || props.show;
  return (
    <div>
      <Link
        to={`/${props.movie ? "movie" : props.show ? "show" : "error"}/${
          value.id
        }`}
      >
        <Card style={{ border: "none" }}>
          <img
            width="100%"
            height="150px"
            style={{ objectFit: "cover", borderRadius: "5px" }}
            src={
              value.image
                ? `data:image/jpeg;base64,${value.image}`
                : defaultImage
            }
            alt={props.movie ? "movie" : props.show ? "show" : "error"}
          />
          <CardTitle className="text-center">{value.title}</CardTitle>
        </Card>
      </Link>
    </div>
  );
}
