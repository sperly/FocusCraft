Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(1, 4, 1, 12, 14, 15),
Block.makeCuboidShape(14, 4, 7, 15, 7, 9),
Block.makeCuboidShape(14, 7, 6, 15, 8, 7),
Block.makeCuboidShape(14, 7, 9, 15, 8, 10),
Block.makeCuboidShape(14, 8, 5, 15, 10, 6),
Block.makeCuboidShape(14, 8, 10, 15, 10, 11)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});