from pathlib import Path
import sys
import json


def make_loot_table(block_id: str) -> dict:
    return {"type": "minecraft:block","pools": [{"rolls": 1,"entries": [{"type": "minecraft:item","name": f"ufm:{block_id}"}]}]}


def put_table(table: dict, path: Path) -> Path | None:
    block_id = str(table["pools"][0]["entries"][0]["name"].split("ufm:")[-1])
    filepath = path.joinpath(f"{block_id}.json")
    if filepath.exists():
        conf = ""
        while conf.lower() != "y":
            try:
                conf = input(f"\"{filepath}\" already exists. Overwrite? [y/N] > ")
            except KeyboardInterrupt:
                print("\n\nAborted.")
                exit(128)
            if not conf or conf.lower() == "n":
                return None
            else:
                print("\x1b[1;31m[X] Please enter Y/y/ or N/n or press Ctrl+C to cancel\x1b[0m")

        with open(filepath, "w") as f:
            json.dump(table, f, indent=2)

    return filepath


def bulk_put_blocks(block_ids: list[str], path: Path) -> list[Path]:
    paths = []
    for block_id in block_ids:
        table = make_loot_table(block_id)
        tpath = put_table(table, path)
        if tpath == None:
            continue
        print(f"Put table {tpath}")
        paths.append(tpath)
    return paths


outdir = Path("../src/main/resources/data/ufm/loot_table/blocks/")

def main() -> Path:
    block_ids = [
        f"lemonwood_{x}" for x in ["log", "planks", "stripped_log", "wood"]
    ] + [
        "lemon_tree_leaves"
    ]

    return bulk_put_blocks(block_ids, outdir)

if __name__ == "__main__":
    table_paths = main()
    print(f"Wrote {len(table_paths)} loot tables to \"{outdir}\".")