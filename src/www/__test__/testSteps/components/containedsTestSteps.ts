// TODO, only screen and within
import { screen } from "@testing-library/react";
import { PostLineStep, step } from "../../testPost";

export const containedsTestSteps: PostLineStep[] = [
  step(
    /The count of producing buildings should be (\d+)/,
    (line, [, expectedCount]) => {
      const counter = screen.getByTestId("producing-building-count");
      expect(counter).toHaveTextContent(expectedCount);
    }
  ),
  step(
    /There should contain at least (\d+) "([^"]+)"/,
    (line, [, count, type]) => {
      const item = queryAllContainedListItem(type);
      expect(item.length).toBeGreaterThanOrEqual(+count);
    }
  ),
  step(
    /There should contain the "([^"]+)" "([^"]+)"/,
    (line, [, type, name]) => {
      const item = getContainedListItem(type, name);
      expect(item).toBeInTheDocument();
    }
  ),
  step(
    /There should not contain the "([^"]+)" "([^"]+)"/,
    (line, [, type, name]) => {
      const item = queryContainedListItem(type, name);
      expect(item).toBeUndefined();
    }
  ),
  step(/Go to the contained "([^"]+)" "([^"]+)"/, (line, [, type, name]) => {
    getContainedListItem(type, name).click();
  }),
];

function queryAllContainedListItem(type: string) {
  const items = screen
    .queryAllByTestId("entity-list-item")
    .filter((i) => i.textContent!.includes(type));

  return items;
}

function getContainedListItem(type: string, name: string) {
  const items = screen
    .queryAllByTestId("entity-list-item")
    .filter((i) => i.textContent!.includes(type))
    .filter((i) => i.textContent!.includes(name));

  expect(items).toHaveLength(1);
  const item = items[0];
  return item;
}

function queryContainedListItem(type: string, name: string) {
  const items = screen
    .queryAllByTestId("entity-list-item")
    .filter((i) => i.textContent!.includes(type))
    .filter((i) => i.textContent!.includes(name));

  const item = items[0];
  return item;
}
