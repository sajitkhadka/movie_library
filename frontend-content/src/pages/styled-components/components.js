import styled from "styled-components";

export const Metadata = styled.div`
  > :not(:last-child) {
    border-right: 1px solid #a3a3a3;
    margin-right: 9px;
    padding-right: 11px;
  }
`;

export const MetadataItem = styled.span`
  font-size: 14px;
  line-height: 18px;
  font-weight: 500;
  color: #a3a3a3;
  display: inline-block;
`;

export const Synopsis = styled.div`
  font-size: 16px;
  line-height: 22px;
  font-weight: 400;
  color: #a3a3a3;
  max-width: 100%;
  padding-top: 16px;
`;

export const Creators = styled.div`
  font-size: 16px;
  line-height: 22px;
  font-weight: 400;
  color: #909090;
  max-width: 100%;
  padding-top: 16px;
`;

export const Title = styled.h1`
@media only screen and (min-width: 1080px) {
  margin: "0 0 3rem 0",
  fontWeight: "bold",
  color: "#3F3D56",
}
margin: "0 0 1rem 0",
`;
